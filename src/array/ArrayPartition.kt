package array

/**
 * Given an integer array nums of 2n integers, group these integers into n pairs (a1, b1), (a2, b2), ..., (an, bn) such that the sum of min(ai, bi) for all i is maximized.
 * Return the maximized sum.
 */
class ArrayPartition {
    fun arrayPairSum(nums: IntArray): Int {
        var sum = 0
        nums.sort()

        for((i,n) in nums.withIndex()) {
            // 뒤에서부터 2개씩 앞에 있는 숫자들을 합하면 가장 최대값이 된다. -> 짝수 인덱스 값들을 모두 합한다.
            if(i % 2 == 0) {
                sum += n
            }
        }
        return sum
    }
}
