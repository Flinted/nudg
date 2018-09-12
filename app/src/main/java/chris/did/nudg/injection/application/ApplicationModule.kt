package chris.did.nudg.injection.application

import android.content.Context
import chris.did.nudg.base.BaseApplication
import dagger.Module
import dagger.Provides
import io.realm.Realm
import kotlinx.coroutines.experimental.android.UI
import kotlin.coroutines.experimental.CoroutineContext

/**
 * ApplicationModule
 */
@Module
class ApplicationModule(private val application: BaseApplication) {

    @Provides
    @ApplicationScope
    fun application(): BaseApplication {
        return application
    }

    @Provides
    @ApplicationScope
    fun provideUICoroutineContext(): CoroutineContext {
        return UI
    }

    @Provides
    @ApplicationScope
    fun context(): Context {
        return application.applicationContext
    }

    @Provides
    @ApplicationScope
    fun provideRealm(): Realm {
        return Realm.getDefaultInstance()
    }
}
