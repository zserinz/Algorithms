package hash_table

/**
 * You're given strings jewels representing the types of stones that are jewels, and stones representing the stones you have. Each character in stones is a type of stone you have. You want to know how many of the stones you have are also jewels.
 *
 * Letters are case sensitive, so "a" is considered a different type of stone from "A".
 */
class JewelsAndStones {
    // using hash set
    fun numJewelsInStones(jewels: String, stones: String): Int {
        var count = 0
        val freqs: MutableSet<Char> = HashSet()

        for (j in jewels.toCharArray())
            freqs.add(j)
        for (s in stones.toCharArray())
            if (freqs.contains(s)) count++
        return count
    }
}