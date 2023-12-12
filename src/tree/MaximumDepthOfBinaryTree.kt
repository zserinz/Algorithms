package tree

import java.util.LinkedList
import java.util.Queue

/**
 * Given the root of a binary tree, return its maximum depth.
 *
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
class MaximumDepthOfBinaryTree {
    fun maxDepth1(root: TreeNode?): Int {
        if (root == null)
            return 0

        val queue: Queue<TreeNode> = LinkedList()
        queue.add(root) // 루트부터 큐에 삽입
        var depth = 0 // 결과로 리턴할 깊이 변수 선언

        // 큐가 모두 비워질 때까지 반복한다.
        while (!queue.isEmpty()) {
            depth += 1 // 반복을 진행할 때마다 깊이 + 1
            val q_size = queue.size // 큐 크기 = 해당 깊이의 모든 노드 수와 일치한다.
            for (i in 0 until q_size) {
                val cur = queue.poll() // 가장 먼저 삽입된 노드부터 추출
                if (cur.left != null) // 왼쪽 자식 노드가 있다면 큐에 삽입
                    queue.add(cur.left)
                if (cur.right != null) //  오른쪽 자식 노드가 있다면 큐에 삽입
                    queue.add(cur.right)
            }
        }

        return depth // BFS 반복 횟수 = 깊이
    }

    fun maxDepth2(root: TreeNode?): Int {
        if (root == null)
            return 0

        var left = maxDepth2(root.left)
        val right = maxDepth2(root.right)
        return Math.max(left, right) + 1
    }
}