package linkedList

/**
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 */
class ReverseLinkedListI {
    // 1. recursive
    fun reverseList1(head: ListNode?): ListNode? {
        return reverse(head, null)
    }
    fun reverse(node: ListNode?, prev: ListNode?): ListNode? {
        if(node === null) return prev;
        val next = node.next; // 현재 노드의 다음 노드 미리 지정
        node.next = prev; // 현재 노드의 다음으로 이전 노드를 지정

        return reverse(next, node) // 다음 노드와 현재 노드를 파라미터로 하여 재귀 호출 -> 끝날때까지 백트래킹 반복
    }

    // 2. iterative
    fun reverseList2(head: ListNode?): ListNode? {
        var prev: ListNode? = null
        var node = head

        while(node != null) {
            val next = node.next
            node.next = prev
            prev = node
            node = next
        }
        return prev
    }
}