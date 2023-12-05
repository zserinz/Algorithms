package depth_first_search

/**
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 *
 */
class NumberOfIslands {
    fun numIslands(grid: Array<CharArray>): Int {
        fun dfs(i: Int, j: Int) {
            when {
                // 현재 위치가 그리드 밖이거나, 물(0)인 경우에는 종료한다.
                // 육지가 아닌 곳에서는 바로 리턴하는 종료 조건을 통해 재귀 호출이 백트래킹으로 모두 빠져나오면 섬 하나를 발견한 것이라고 할 수 있다.
                (i < 0) ||
                        (j >= grid.size) ||
                        (j < 0) ||
                        (j >= grid[0].size) ||
                        (grid[i][j] == '0') -> return
            }
            grid[i][j] = '0' // 한 번만 탐색하기 위해서 탐색한 지점은 물(0)로 변경한다.

            // 동서남북 재귀 DFS
            dfs(i, j+1) // 동
            dfs(i, j-1) // 서
            dfs(i+1, j) // 남
            dfs(i-1, j) // 북
        }

        var count = 0
        for (i in grid.indices) { // 행렬을 모두 탐색한다.
            for (j in grid[i].indices) {
                // 육지(1)인 경우에 탐색을 시작한다.
                if (grid[i][j] == '1') {
                    dfs(i,j)
                    // 재귀 DFS가 모두 끝남녀 섬 하나가 완성되었으므로 개수 + 1
                    count++
                }
            }
        }
        return count
    }
}