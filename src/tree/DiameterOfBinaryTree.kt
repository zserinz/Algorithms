package tree

import kotlin.math.max

/**
 * Given the root of a binary tree, return the length of the diameter of the tree.
 *
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 *
 * The length of a path between two nodes is represented by the number of edges between them.
 */
class DiameterOfBinaryTree {
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        var longest = 0

        fun dfs(node: TreeNode?): Int {
            if (node == null)
                return -1
            val left = dfs(node.left) // 왼쪽, 오른쪽 각 리프 노드까지 재귀 DFS
            val right = dfs(node.right)

            longest = max(longest, left + right +2) // 가장 긴 경로를 계산한다.
            return max(left, right) + 1 // 왼쪽, 오른쪽 노드 중에서 큰 값에 +1
        }

        dfs(root)
        return longest
    }
}