package stack_queue

import java.util.ArrayDeque
import java.util.Deque

/**
 * Given an array of integers temperatures represents the daily temperatures,
 * return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature.
 * If there is no future day for which this is possible, keep answer[i] == 0 instead.
 */

class DailyTemperatures {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val result = IntArray(temperatures.size) // 결과를 담을 배열 지정
        val stack: Deque<Int> = ArrayDeque()

        for (i in temperatures.indices) {
            // 현재 온도가 스택에 있는 온도보다 높다면 꺼내서 결과를 업데이트
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                val last = stack.pop()
                result[last] = i - last // 인덱스 차이 계산하여 결과 배열에 저장
            }
            stack.push(i) // 현재 인덱스를 스택에 삽입
        }
        return result
    }
}