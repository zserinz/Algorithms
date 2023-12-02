package priority_queue

import java.util.PriorityQueue
import java.util.Queue

/**
 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).
 *
 * The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
 *
 * You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).
 */
class KClosestPointsToOrigin {
    // 거리와 좌표를 저장할 데이터 클래스 Point
    data class Point(var distance: Long, var point: IntArray)

    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        // Point 클래스를 저장하는 우선순위 큐
        // 정렬 기준은 distance로 하여 가장 가까운 순서대로 쌓일 수 있도록 한다.
        val pq: Queue<Point>  = PriorityQueue(compareBy {a -> a.distance})

        for (point in points) {
            // 유클리드 거리 계산
            val distance = point[0].toLong() * point[0] + point[1].toLong() * point[1]
            // 우선순위 큐에 거리와 좌표를 Point 클래스에 담아 삽입
            pq.add(Point(distance, point))
        }

        // 결과 변수 선언
        val results: Array<IntArray> = Array(k) { IntArray(2) { 0 } }
        for (i in 0 until k) {
            // 우선순위 큐에서 추출한 Point 클래스의 좌표를 결과로 삽입
            results[i] = pq.poll().point
        }

        return results
    }
}