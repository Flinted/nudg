package chris.did.nudg.base

import android.app.Activity
import android.app.Application
import android.support.annotation.UiThread
import chris.did.nudg.BuildConfig
import chris.did.nudg.analytics.Analytics
import chris.did.nudg.injection.application.*
import chris.did.nudg.injection.viewmodels.ActivityModule
import chris.did.nudg.overview.OverviewViewModelModule
import com.crashlytics.android.Crashlytics
import io.fabric.sdk.android.Fabric
import io.realm.Realm
import io.realm.RealmConfiguration

/**
 * BaseApplication
 */
class BaseApplication : Application() {

    private var applicationComponent: ApplicationComponent? = null

    override fun onCreate() {
        super.onCreate()
        initialiseFabric()
        initialiseRealm()
    }

    private fun initialiseRealm() {
        Realm.init(this)
        val realmConfiguration = RealmConfiguration.Builder()
            .build()
        Realm.setDefaultConfiguration(realmConfiguration)
    }

    @UiThread
    fun getApplicationComponent() = this.applicationComponent ?: createApplicationComponent()

    @UiThread
    fun getViewModelComponent(activity: Activity) = createViewModelComponent(activity)

    private fun createApplicationComponent(): ApplicationComponent {
        val applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .factoryModule(FactoryModule())
            .useCaseModule(UseCaseModule())
            .build()
        this.applicationComponent = applicationComponent
        return applicationComponent
    }

    private fun createViewModelComponent(activity: Activity) = getApplicationComponent()
        .getViewModelComponent(
            ActivityModule(activity),
            OverviewViewModelModule()
        )

    private fun initialiseFabric() {
        if (BuildConfig.DEBUG) {
            return
        }
        Analytics.setInitialValues(this)
        Fabric.with(this, Crashlytics())
    }
}