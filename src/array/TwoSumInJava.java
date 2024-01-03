package array;

import java.util.HashMap;
import java.util.Map;

public class TwoSumInJava {
    // 풀이 1. 반복문을 통한 완전 탐색 구현 -> 가장 기본적인 반복문 풀이이지만 시간 복잡도는 O(n^2)이므로 비효율적이다. 최적화하는 방법이 필요하다.
    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    // 풀이 2. 첫 번째 수를 뺀 결과 키를 조회 -> 위 풀이를 개선해 보자
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numsMap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (numsMap.containsKey(target - nums[i]) && i != numsMap.get(target - nums[i]))
                return new int[]{i, numsMap.get(target - nums[i])};
        }

        return null;
    }
}
