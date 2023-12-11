package depth_first_search

import java.util.ArrayDeque
import java.util.Deque
import java.util.LinkedList
import java.util.PriorityQueue

/**
 * You are given a list of airline tickets where tickets[i] = [from, to] represent the departure and the arrival airports of one flight. Reconstruct the itinerary in order and return it.
 *
 * All of the tickets belong to a man who departs from "JFK", thus, the itinerary must begin with "JFK". If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string.
 *
 * For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
 * You may assume all tickets form at least one valid itinerary. You must use all the tickets once and only once.
 */
class ReconstructItinerary {
    fun findItinerary(tickets: List<List<String>>): List<String> {
        val fromToMap: MutableMap<String, PriorityQueue<String>> = mutableMapOf()

        // 여행 일정을 from -> to 형태의 그래프로 구성한다.
        for (ticket in tickets) {
            fromToMap.putIfAbsent(ticket[0], PriorityQueue()) // 값이 존재하지 않을 경우 빈 우선순위 큐 생성
            fromToMap[ticket[0]]!!.add(ticket[1]) // 목적지 to 추가, 우선순위 큐이므로 to는 항상 사전 어휘순으로 정렬된다.
        }
        val result: MutableList<String> = LinkedList()
        val stack: Deque<String> = ArrayDeque()

        stack.push("JFK") // 출발지 삽입

        while (!stack.isEmpty()) {
            // 스택에서 추출될 값을 출발지로 한 도착지를 처리한다.
            while (fromToMap.containsKey(stack.first) && !fromToMap[stack.first]!!.isEmpty()) {
                // 여러 도착지 중에서 사전 어휘 순으로 추출하여 스택에 삽입한다.
                stack.push(fromToMap[stack.first]!!.poll())
            }

            // 위 반복문이 모두 실행된 이후에는 스택에서 값이 하나씩 추출되어 정답으로 구성된다.
            result.add(0, stack.poll())
        }
        return result
    }
}