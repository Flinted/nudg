package chris.did.nudg.injection.application

import chris.did.nudg.base.BaseApplication
import chris.did.nudg.injection.viewmodels.ActivityModule
import chris.did.nudg.injection.viewmodels.ViewModelComponent
import chris.did.nudg.overview.OverviewViewModelModule
import dagger.Component

/**
 * ApplicationComponent
 */
@ApplicationScope
@Component(
    modules = [
        ApplicationModule::class,
        FactoryModule::class,
        UseCaseModule::class
    ]
)
interface ApplicationComponent {

    fun inject(application: BaseApplication)

    fun getViewModelComponent(
        viewModelModule: ActivityModule,
        overviewViewModelModule: OverviewViewModelModule
    ): ViewModelComponent
}