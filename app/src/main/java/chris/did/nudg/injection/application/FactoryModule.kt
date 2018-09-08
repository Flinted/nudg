package chris.did.nudg.injection.application

import chris.did.presentation.nudgfactory.NudgCreator
import chris.did.presentation.nudgfactory.NudgFactory
import chris.did.presentation.nudgfactory.TagFactory
import chris.did.presentation.nudgfactory.TagParser
import dagger.Module
import dagger.Provides

/**
 * FactoryModule
 */
@Module
class FactoryModule {

    @Provides
    fun provideTagFactory(): TagParser {
        return TagFactory(hashSetOf("MON"))
    }

    @Provides
    fun provideNudgFactory(tagFactory: TagParser): NudgCreator {
        return NudgFactory(tagFactory)
    }
}
