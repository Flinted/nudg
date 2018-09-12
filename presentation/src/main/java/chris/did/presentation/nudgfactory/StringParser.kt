package chris.did.presentation.nudgfactory

import java.util.regex.Pattern

/**
 * StringParser
 */
object StringParser {

    private val standardTextRegex = "([^\\#]+)"
    private val dateRegex = "(#\\d{4}\\/\\d{2}\\/\\d{2})"
    private val tagRegex = "(#\\w+)"
    private val tagOrDateRegex = "$dateRegex|$tagRegex"
    private val sectionRegex = "$dateRegex|$tagRegex"
    private val tagPattern = Pattern.compile(tagOrDateRegex)
    private val datePattern = Pattern.compile(dateRegex)
    private val sectioningPattern = Pattern.compile(sectionRegex)

    fun parseStringIntoSections(input: String): List<String> {
        val matcher = sectioningPattern.matcher(input)
        val stringSections = mutableListOf<String>()
        while (matcher.find()) {
            val stringSegment = matcher.group(1) ?: matcher.group(2)
            stringSegment ?: throw Exception("Cannot recognise input")
            stringSections.add(stringSegment)
        }
        return stringSections.toList()
    }

    fun isTag(input: String): Boolean {
        return tagPattern.matcher(input).matches()
    }

    fun isDateTag(input: String): Boolean {
        return datePattern.matcher(input).matches()
    }
}
