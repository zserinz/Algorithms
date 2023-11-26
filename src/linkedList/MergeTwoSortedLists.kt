package linkedList

/**
 * You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
 * Return the head of the merged linked list.
 */

class MergeTwoSortedLists {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        if(list1 == null) return list2
        if(list2 == null) return list1

        return if(list1.`val`<list2.`val`) {
            list1.next = mergeTwoLists(list1.next, list2) // l2가 더 크면 l1에 재귀 호출 결과를 엮어서 l1을 리턴
            list1
        } else {
            list2.next = mergeTwoLists(list1, list2.next) // l1이 더 크면 l2에 재귀 호출 결과를 엮어서 l2를 리턴
            list2
        }
    }
}