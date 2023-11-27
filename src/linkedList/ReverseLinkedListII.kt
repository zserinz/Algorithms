package linkedList

/**
 * Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.
 */
class ReverseLinkedListII {
    fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
        if (head == null) return null

        val root = ListNode(0) // 임시 노드
        root.next = head // 임시 노드 다음으로 노드 시작
        var start = root

        for (i in 0 until left - 1)
            start = start.next!!

        val end = start.next // 변경이 필요한 마지막 위치 선언

        for (i in 0 until right - left) { // 지정된 범위만큼 위치 변경 진행
            val tmp = start.next
            start.next = end?.next
            end?.next = end?.next?.next
            start.next?.next = tmp
        }

        return root.next // 시작한 노드부터 결과로 리턴
    }
}