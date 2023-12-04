package hash_table

import java.util.PriorityQueue

/**
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 */
class TopKFrequentElements {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        // 각 엘리먼트의 빈도수를 저장할 해시맵 선언
        val frequencyMap: MutableMap<Int, Int> = mutableMapOf()
        for (n in nums) { // 각 엘리먼트의 빈도수를 반복하며 계산하여 저장한다.
            // 처음 빈도수를 계산하는 엘리먼트는 기본값 0, 모두 +1 하여 저장
            frequencyMap[n] = frequencyMap.getOrDefault(n, 0) + 1
        }

        // 빈도순으로 정렬될 우선순위 큐 선언
        val pq: PriorityQueue<IntArray> = PriorityQueue { a: IntArray, b: IntArray ->
            b[1] - a[1]
        }
        // 우선순위 큐에 각 엘리먼드와 빈도수를 삽입
        for (elem in frequencyMap.keys) {
            pq.add(intArrayOf(elem, frequencyMap[elem]!!))
        }

        val result = IntArray(k)
        for (i in 0 until k) { // k번까지만 반복하여 우선순위 큐에서 결과 추출하기
            result[i] = pq.poll()[0]
        }

        return result
    }
}