package array

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 * 아이디어 -> 변곡점을 세자! 변곡점 사이의 거리와 부피로 물이 쌓인 양들을 더해가자.
 */
class TrappingRainWater {
    // sol 1.
    fun trap(height: IntArray): Int {
        // 변곡점 이전의 인덱스 스택
        val stack = ArrayDeque<Int>()
        // 물의 총 양
        var volume = 0

        for (i in height.indices) {
            while (stack.isNotEmpty() && height[i] > height[stack.last()]) {
                val top = stack.removeLast()
                if (stack.isEmpty()) {
                    break
                }
                val distance = i - stack.last() - 1
                val waters = Math.min(height[i], height[stack.last()]) - height[top]
                volume += distance * waters
            }
            stack.addLast(i)
        }

        return volume
    }

    fun main() {
        val height = intArrayOf(0,1,0,2,1,0,1,3,2,1,2,1)
        println(trap(height))  // 출력: 6
    }
}
