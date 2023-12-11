package depth_first_search

/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 *
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 */
class CourseSchedule {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val finishToTakeMap: MutableMap<Int, MutableList<Int>> = mutableMapOf()

        // 완료하기 위해 처리해야 하는 일정을 finish -> take 형태의 그래프로 그성
        for (pre in prerequisites) {
            finishToTakeMap.putIfAbsent(pre[0], mutableListOf()) // 값이 존재하지 않을 경우 빈 리스트
            finishToTakeMap[pre[0]]!!.add(pre[1]) // 처리해야 하는 코스 추가
        }

        val takes: MutableList<Int> = mutableListOf() // 처리해야 하는 노드를 저장하는 변수
        val taken: MutableList<Int> = mutableListOf() // 이미 처리한 노드를 저장하는 변수

        fun dfs(finish: Int, takes: MutableList<Int>, taken: MutableList<Int>): Boolean {
            if (takes.contains(finish)) // 완료해야 하는 노드가 처리해야 하는 노드에 이미 포함되어 있다면
                return false // 그래프가 순환 구조이므로 false 리턴

            if (taken.contains(finish)) // 이미 처리한 노드가 존재한다면 true
                return true

            if (finishToTakeMap.containsKey(finish)) { // 완료해야 하는 코스에 값이 있다면
                takes.add(finish) // 처리해야 한느 노드에 현재 완료해야 하는 노드 추가
                for (take in finishToTakeMap[finish]!!) {
                    if (!dfs(take, takes, taken)) // 재귀 DFS 실행
                        return false
                }

                takes.remove(finish) // 탐색 후에 처리되었으므로 노드 제거
                taken.add(finish) // 이미 처리한 노드 변수에 추가
            }
            return true
        }

        for (finish in finishToTakeMap.keys) { // 완료해야 하는 노드 순회
            if (!dfs(finish, takes, taken))
                return false
        }

        return true // 최종 모든 코스에 문제가 없으면 true 리턴
    }
}