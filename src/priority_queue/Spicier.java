package priority_queue;

import java.util.PriorityQueue;

/**
 * ❓ 매운 것을 좋아하는 Leo는 모든 음식의 스코빌 지수를 K 이상으로 만들고 싶습니다. 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 Leo는 스코빌 지수가 **가장 낮은 두 개의 음식**을 아래와 같이 특별한 방법으로 섞어 새로운 음식을 만듭니다.
 * `섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)`
 * Leo는 모든 음식의 스코빌 지수가 K 이상이 될 때까지 반복하여 섞습니다.
 * Leo가 가진 음식의 스코빌 지수를 담은 배열 scoville과 원하는 스코빌 지수 K가 주어질 때, 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 섞어야 하는 최소 횟수를 return 하도록 solution 함수를 작성해주세요.
 */
class Spicier {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // 차례대로 추출하기 위해 우선순위 큐에 모두 삽입
        for (int s: scoville) {
            pq.add(s);
        }

        int answer = 1;
        while (pq.size() >= 2) {
            // 두 음식을 섞어서 새로운 음식을 추가
            pq.add(pq.poll() + (pq.poll()*2));
            // 가장 안 매운 음식이 K 이상이면, 정답 바로 리턴
            if (pq.peek() >= K)
                return answer;
            answer++;
        }

        // 모두 섞었음에도 K를 넘지 않을 경우에는 -1 리턴
        return -1;
    }
}