package array

/**
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 */
class ProductOfArrayExceptSelf {
    fun productExceptSelf(nums: IntArray): IntArray {
        val result = IntArray(nums.size)

        // 왼쪽 곱셈
        var p = 1
        for (i in nums.indices) {
            result[i] = p
            p *= nums[i]
        }

        // 오른쪽 곱셈
        p = 1
        for (i in nums.indices.reversed()) {
            result[i] *= p // 왼쪽 곱셈의 결과에 역순 정렬된 곱을 곱한다.
            p *= nums[i]
        }

        return result
    }
}
