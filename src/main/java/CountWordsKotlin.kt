import CountWords.S2

fun getWordsSortedByFreq(text: String): List<String> {
    val words = text.lowercase()
        .split("[^a-zа-я0-9]+".toRegex())
        .groupingBy { it }.eachCount()
        .toList()
        .sortedWith(compareByDescending<Pair<String, Int>> { it.second }.thenBy { it.first })
        .take(10)
        .map { it.first }
    return words
}

fun main() {
    val words = getWordsSortedByFreq(S2)
    words.forEach { println(it) }
}