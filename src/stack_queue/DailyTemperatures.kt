package stack_queue

import java.util.ArrayDeque
import java.util.Deque

class DailyTemperatures {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val result = IntArray(temperatures.size)
        val stack: Deque<Int> = ArrayDeque()
        for (i in temperatures.indices) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                val last = stack.pop()
                result[last] = i-last
            }
            stack.push(i)
        }
        return result
    }
}