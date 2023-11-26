package linkedList

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
 */
class SwapNodesInPairs {
    // 1. 반복 구조로 스왑
    fun swapPairs1(head: ListNode?): ListNode? {
        var node = ListNode(0)
        val root = node
        node.next = head
        while(node.next != null && node.next!!.next != null) {
            val a = node.next // 1칸 앞으로
            val b = node.next!!.next // 2칸 앞으로

            a!!.next = b!!.next
            node.next = b
            node.next!!.next = a

            node = node.next!!.next!!
        }
        return root.next
    }

    // 2. 재귀
    fun swapPairs2(head: ListNode?): ListNode? {
        // [1,2,3,4] 일 경우,
        if (head?.next != null) { // head = 1
            val p = head.next // 2
            head.next = swapPairs2(head.next!!.next) // sp([3,4]) 호출 - head = 3, p = 4 // 다음은 sp(null) 호출
            p!!.next = head // 노드 교환 [2,1] [4,3]
            return p
        }
        return head
    }
}