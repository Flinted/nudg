package chris.did.nudg.injection.application

import chris.did.presentation.nudgfactory.NudgCreator
import chris.did.presentation.nudgfactory.NudgFactory
import chris.did.presentation.nudgfactory.SectionFactory
import chris.did.presentation.nudgfactory.SectionParser
import chris.did.presentation.nudgviewmodelfactory.NudgViewModelCreator
import chris.did.presentation.nudgviewmodelfactory.NudgViewModelFactory
import chris.did.presentation.nudgviewmodelfactory.TagViewModelCreator
import chris.did.presentation.nudgviewmodelfactory.TagViewModelFactory
import dagger.Module
import dagger.Provides

/**
 * FactoryModule
 */
@Module
class FactoryModule {

    @Provides
    fun provideTagFactory(): SectionParser {
        return SectionFactory(hashSetOf("MON"))
    }

    @Provides
    fun provideNudgFactory(tagFactory: SectionParser): NudgCreator {
        return NudgFactory(tagFactory)
    }

    @Provides
    fun provideTagViewModelFactory(): TagViewModelCreator {
        return TagViewModelFactory()
    }

    @Provides
    fun provideNudgViewModelFactory(tagViewModelFactory: TagViewModelCreator): NudgViewModelCreator {
        return NudgViewModelFactory(tagViewModelFactory)
    }
}
