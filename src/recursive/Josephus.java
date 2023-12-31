package recursive;

/**
 * << 문 제 >> =========================================================================================================
 * 1번부터 n 번까지 총 n 명의 사람이 원형으로 모여있다.
 * 1명의 생존자만 남을 때까지, 원의 임의의 위치로부터 매 k번째 자리에 위치한 사람은 죽어야 한다.
 * 이때 생존자의 위치를 찾느 알고리즘을 작성하시오.
 * << 풀이 아이디어 >> ====================================================================================================
 * 1. n명의 사람 중, 매 k번째 사람을 주긴다.
 * 2. k번째 사람을 죽인 후, josephus(n-1,k) 를 호출한다.
 *    => 매 시도마다 (josephus(n-1,k) + k - 1) % n + 1 를 반환하도록 위치를 조정해야 한다.
 *    J(n) = (J(n-1) 위치 + k) % n + 1 (인덱스가 1부터 시작함을 알자.)
 * 3. 원의 크기가 줄어든 이전 상태를 기반으로 새로운 위치를 계산하는 것이 핵심일 것이다.
 * ====================================================================================================================
 */
public class Josephus {
    public static int josephus(int n, int k) {
        // 예외 처리
        if (k <= 0 || n <= 0) {
            return -1;
        }

        if (n == 1) {
            return 1;
        } else {
            return (josephus(n - 1, k) + k - 1) % n + 1;
        }
    }

    public static void main(String[] args) {
        // 15명 중 1명만 남을 때까지 3 번째 사람을 제거한다고 하자.
        // 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15
        // 1 라운드 : 3,6,8,12,15 사망 -> 1부터 시작
        // 2 라운드 : 4,8,13 사망 -> 14부터 시작
        // 3 라운드 : 2,10,1 사망 -> 5부터 시작
        // 4 라운드 : 11,7 사망 -> 14부터 시작
        // 5 라운드 : 14 사망
        // -> 해당 예시로 n,k에 적용할 수 있는 규칙을 알 수 있다.
        int n = 15;
        int k = 3;

        System.out.println("생존자는... " + Josephus.josephus(n, k) + "\n" + "번!");
    }
}
