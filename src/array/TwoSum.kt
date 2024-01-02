package array

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 */
class TwoSum {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val numsMap: MutableMap<Int, Int> = mutableMapOf()

        for ((i, num) in nums.withIndex()) {
            if (numsMap.containsKey(target - num)) {
                return intArrayOf(numsMap[target - num] ?: 0, i)
            }
            numsMap[num] = i
        }

        return intArrayOf(0, 0)
    }
}
