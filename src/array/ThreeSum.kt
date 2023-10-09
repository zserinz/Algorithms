package array

import java.util.Arrays

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 */
class ThreeSum {
    fun threeSum(nums: IntArray): List<List<Int>> {
        var left: Int
        var right: Int
        var sum: Int
        val results: MutableList<List<Int>> = mutableListOf()
        Arrays.sort(nums)

        for (i in 0 until nums.size - 2) {
            // 중복 값 건너뛰기
            if (i>0 && nums[i] == nums[i-1]) continue

            // 간격을 좁혀가며 sum 계산하기
            left = i+1
            right = nums.size - 1
            while (left<right) {
                sum = nums[i] + nums[left] + nums[right]
                if (sum<0) {
                    left += 1
                } else if (sum>0) {
                    right -= 1
                } else {
                    // 합이 0이면 결과값 처리
                    results.add(listOf(nums[i], nums[left], nums[right]))

                    // 중복된 값 건너뛰기
                    while (left<right && nums[left]==nums[left+1])
                        left += 1
                    // 이미 정답이 나왔으므로 양쪽 모두 이동
                    left += 1
                    right -= 1
                }
            }
        }
        return results
    }
}
