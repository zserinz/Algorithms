package depth_first_search

import java.util.*
import java.util.stream.Collectors
import kotlin.collections.ArrayList

/**
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 */
class Permutations {
    fun permute(nums: IntArray): List<List<Int>> {
        val results: MutableList<List<Int>> = mutableListOf()

        fun dfs(prevElements: MutableList<Int>, elements: List<Int>) {
            // 리프 노드에 도달하면 결과에 추가
            if (elements.isEmpty()) {
                // 스트림을 이용해서 prevElements의 내용을 결과에 삽입
                results.add(prevElements.stream().collect(Collectors.toList()))
            }
            // 전달 받은 모든 엘리먼츠들을 탐색해 나간다.
            for (e in elements) {
                // 전달받은 엘리먼트에서 현재 엘리먼트를 제외하고 nextElements를 새롭게 구성한다.
                val nextElements: MutableList<Int> = ArrayList(elements)
                nextElements.remove(e)

                prevElements.add(e) // prevElements 에는 현재 엘리먼트를 추가
                dfs(prevElements, nextElements) // 재귀 DFS 실행
                prevElements.remove(e) // 돌아온 이후에는 prevElements 에서 현재 엘리먼트 삭제
            }
        }

        val list = Arrays.stream(nums).boxed().collect(Collectors.toList())
        dfs(mutableListOf(), list)
        return results
    }
}