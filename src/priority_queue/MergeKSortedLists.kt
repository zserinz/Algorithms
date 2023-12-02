package priority_queue

import linkedList.ListNode
import java.util.PriorityQueue

/**
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * Merge all the linked-lists into one sorted linked-list and return it.
 *
 * -> 실제 릿코드 난이도는 Hard 로 표기되어 있지만, 우선순위 큐를 사용하면 쉽게 풀이할 수 있다.
 */

class MergeKSortedLists {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        // o1 : 새로운 값
        // o2 : 기존 값
        val pq = PriorityQueue<ListNode> { o1, o2 ->
            when {
                o1.`val` === o2.`val` -> 0 // 동일한 길이값이면 무시
                o1.`val` > o2.`val` -> 1 // 새로운 값이 기존 값보다 크면 뒤에 위치
                else -> -1 //  작으면 앞에 위치
            }
        }
        val root = ListNode(0)
        var tail = root

        // 주어진 각 연결 리스트의 첫 번째 노드를 큐에 저장한다.
        // 각 첫번째 노드들을 순서대로 우선순위 큐에 넣는다면 최종적으로 정렬이 될 것이다.
        for (node in lists)
            if (node != null)
                pq.add(node)

        // 큐가 모두 빌 때까지 반복
        while (!pq.isEmpty()) {
            val nextNode = pq.poll() // 우선순위에 따라 추출 -> 다음 노드로 이동
            tail.next = nextNode
            tail = nextNode

            if (tail.next != null) // 추출한 연결 리스트의 다음 노드는 다시 큐에 저장
                pq.add(tail.next)
        }

        return root.next
    }
}