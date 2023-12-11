package dijkstra

import java.util.*

/**
 * You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.
 *
 * We will send a signal from a given node k. Return the minimum time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.
 */
class NetworkDelayTime {
    fun networkDelayTime(times: Array<IntArray>, n: Int, k: Int): Int {
        // 네트워크의 각 노드를 [ 출발지 -> 도착지 ] 형태의 그래프로 구성한다.
        val graph: MutableMap<Int, MutableMap<Int, Int>> = mutableMapOf()
        for (time in times) {
            graph.putIfAbsent(time[0], mutableMapOf()) // 값이 존재하지 않을 경우 빈 해시맵
            graph[time[0]]!![time[1]] = time[2] // 출발지에 (도착지, 소요시간) 추가
        }

        // (도착지, 소요 시간)으로 구성되는 우선순위 큐 생성 -> 정렬 기준은 소요 시간을 기준으로 한다.
        val pq: Queue<Map.Entry<Int, Int>> = PriorityQueue(compareBy { (node, time) -> time })
        pq.add(AbstractMap.SimpleEntry(k, 0)) // (도착지, 소요시간)을 큐에 삽입, 출발지=k, 소요 시간=0(default)

        val dist: MutableMap<Int, Int> = mutableMapOf() // (도착지, 소요시간) 최종 결과를 저장하는 변수 선언
        while (!pq.isEmpty()) {
            val (u, dist_u) = pq.poll() // 소요시간이 가장 빠른 값 추출
            if (!dist.containsKey(u)) { // u 지점까지의 소요 시간이 아직 계산되지 않았다면 처리 시작
                dist[u] = dist_u // u 지점까지의 소요 시간(dist_u)을 결과 변수에 삽입
                if (graph.containsKey(u)) { // u 지점을 출발지로 한 모든 경로 순회
                    for ((v, length_u_v) in graph[u]!!) { // u지점까지의 소요 시간(dist_u) + u 지점을 출발지로 한 도착지까지의 소요 시간(length_u_v)
                        val alt = dist_u + length_u_v
                        pq.add(AbstractMap.SimpleEntry(v, alt)) // 우선순위 큐에 (도착지, 소요시간) 삽입
                    }
                }
            }
        }

        return if (dist.size == n)
            // 결과 변수가 노드의 수와 같다면 모든 노드의 소요 시간을 측정하였고, 도달 가능하다는 의미이므로 해당 값 리턴
            Collections.max(dist.values)
        else
            // 같지 않다면 일부 노드는 도달할 수 없으므로 -1 리턴
            -1
    }
}