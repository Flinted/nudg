package chris.did.nudg.injection.application

import android.content.Context
import chris.did.data.nudgservice.NudgServicable
import chris.did.data.nudgservice.NudgService
import chris.did.data.repository.NudgRepository
import chris.did.data.repository.Repository
import dagger.Module
import dagger.Provides

/**
 * UseCaseModule
 */

@Module
class UseCaseModule {

    @Provides
    fun provideNudgRepository(context: Context): Repository {
        return NudgRepository(context)
    }

    @Provides
    fun provideNudgService(repository: Repository): NudgServicable {
        return NudgService(repository)
    }
}
