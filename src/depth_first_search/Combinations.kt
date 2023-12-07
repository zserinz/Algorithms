package depth_first_search

import java.util.LinkedList
import java.util.stream.Collectors

/**
 * Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
 * You may return the answer in any order.
 */
class Combinations {
    fun combine(n: Int, k: Int): List<List<Int>> {
        val results: MutableList<List<Int>> = mutableListOf()

        fun dfs(elements: LinkedList<Int>, start: Int, k: Int) {
            // k 번째 노드에 도착하면 결과값 리턴
            if (k == 0) {
                results.add(elements.stream().collect(Collectors.toList()))
                return
            }

            // 현재 엘리먼트 이후 엘리먼트 탐색
            for (i in start..n) {
                elements.add(i) // 전달 받은 엘리먼트에 더해 현재 엘리먼트 추가
                dfs(elements, i+1, k-1) // 재귀 DFS
                elements.removeLast() // 돌아온 이후에는 현재 엘리먼트 삭제
            }
        }

        dfs(LinkedList(), 1, k) // DFS 시작
        return results
    }
}