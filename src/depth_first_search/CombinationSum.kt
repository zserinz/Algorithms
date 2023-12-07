package depth_first_search

import java.util.ArrayDeque
import java.util.Deque

/**
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
 *
 * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
 * frequency
 *  of at least one of the chosen numbers is different.
 *
 * The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
 */
class CombinationSum {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val results: MutableList<List<Int>> = mutableListOf()

        fun dfs(target: Int, index: Int, path: Deque<Int>) {
            if (target < 0) return // 값을 초과했으므로 종료
            if (target == 0) { // 목푯값과 동일하므로 결과에 추가하고 리턴
                results.add(ArrayList(path))
                return
            }

            // 자기 자신보다 큰 숫자를 DFS 진행
            for (i in index until candidates.size) {
                path.add(candidates[i]) // path 에 현재 엘리먼트 추가
                dfs(target - candidates[i], i, path) // 재귀 DFS
                path.removeLast() // 돌아온 이후 현재 엘리먼트 삭제
            }
        }

        dfs(target, 0, ArrayDeque()) // DFS 시작
        return results
    }
}