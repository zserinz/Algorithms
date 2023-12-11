package depth_first_search

import java.util.ArrayDeque
import java.util.Deque

/**
 * Given an integer array nums of unique elements, return all possible
 * subsets
 *  (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 */
class Subsets {
    fun subsets(nums: IntArray): List<List<Int>> {
        val results: MutableList<List<Int>> = mutableListOf()

        fun dfs(index: Int, path: Deque<Int>) {
            results.add(ArrayList(path)) // 모든 탐색 경로를 매번 결과에 추가한다.
            // 자기보다 큰 숫자를 DFS 진행한다.
            for (i in index until nums.size) {
                path.add(nums[i]) // 현재 엘리먼트 추가
                dfs(i+1, path) // 재귀 DFS
                path.removeLast() // 돌아온 이후 현재 엘리먼트 삭제
            }
        }

        dfs(0, ArrayDeque()) // DFS 시작
        return results
    }
}