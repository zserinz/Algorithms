package linkedList

/**
 * Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.
 * The first node is considered odd, and the second node is even, and so on.
 * Note that the relative order inside both the even and odd groups should remain as it was in the input.
 * You must solve the problem in O(1) extra space complexity and O(n) time complexity.
 */
class OddEvenLinkedList {
    fun oddEvenList(head: ListNode?): ListNode? {
        if(head == null) return null

        var odd: ListNode = head // 홀수 노드
        var even = head.next // 짝수 노드
        val evenHead = even // 짝수의 첫번째 노드

        while (even?.next != null) { // 반복하면서 홀짝 노드를 처리한다.
            odd.next = odd.next?.next
            even.next = even.next?.next

            odd = odd.next!!
            even = even.next
        }
        odd.next = evenHead // 홀수 노드의 마지막 + 짝수 노드의 처음
        return head
    }
}