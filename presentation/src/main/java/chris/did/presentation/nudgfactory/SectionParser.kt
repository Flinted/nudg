package chris.did.presentation.nudgfactory

import chris.did.presentation.nudg.section.Section

/**
 * TagExtractor
 */
interface SectionParser {

    fun parseSections(input: List<String>): List<Section>
}
