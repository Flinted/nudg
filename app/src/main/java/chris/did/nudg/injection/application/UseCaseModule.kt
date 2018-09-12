package chris.did.nudg.injection.application

import chris.did.data.nudgservice.NudgServicable
import chris.did.data.nudgservice.NudgService
import chris.did.data.repository.RealmNudgRepository
import chris.did.data.repository.Repository
import dagger.Module
import dagger.Provides

/**
 * UseCaseModule
 */

@Module
class UseCaseModule {

    @Provides
    fun provideNudgRepository(): Repository {
        return RealmNudgRepository()
    }

    @Provides
    fun provideNudgService(repository: Repository): NudgServicable {
        return NudgService(repository)
    }
}
