package depth_first_search

import java.util.ArrayDeque
import java.util.Deque
import java.util.LinkedList
import java.util.PriorityQueue

class ReconstructItinerary {
    fun findItinerary(tickets: List<List<String>>): List<String> {
        val fromToMap: MutableMap<String, PriorityQueue<String>> = mutableMapOf()
        for (ticket in tickets) {
            fromToMap.putIfAbsent(ticket[0], PriorityQueue())
            fromToMap[ticket[0]]!!.add(ticket[1])
        }
        val result: MutableList<String> = LinkedList()
        val stack: Deque<String> = ArrayDeque()

        stack.push("JFK")
        while (!stack.isEmpty()) {
            while (fromToMap.containsKey(stack.first) && !fromToMap[stack.first]!!.isEmpty()) {
                stack.push(fromToMap[stack.first]!!.poll())
            }

            result.add(0, stack.poll())
        }
        return result
    }
}