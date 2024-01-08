package nossi_practice.week_1_exhaustive_search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * You are given an integer array nums of 2 * n integers. You need to partition nums into two arrays of length n to minimize the absolute difference of the sums of the arrays. To partition nums, put each element of nums into one of the two arrays.
 * Return the minimum possible absolute difference.
 */
public class PartitionArray {
    private int minDiff = Integer.MAX_VALUE;

    public int minimumDifference(int[] nums) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        backtrack(nums, 0, list1, list2);
        return minDiff;
    }

    private void backtrack(int[] nums, int index, List<Integer> list1, List<Integer> list2) {
        // 모든 숫자가 할당되었을 때
        if (index == nums.length) {
            // 두 그룹이 같은 크기인지 확인
            if (list1.size() == list2.size()) {
                int sum1 = 0, sum2 = 0;
                for (int num : list1) sum1 += num;
                for (int num : list2) sum2 += num;
                // 최소 차이 업데이트
                minDiff = Math.min(minDiff, Math.abs(sum1 - sum2));
            }
            return;
        }

        // 현재 숫자를 첫 번째 그룹에 추가
        if (list1.size() < nums.length / 2) {
            list1.add(nums[index]);
            backtrack(nums, index + 1, list1, list2);
            list1.remove(list1.size() - 1);
        }

        // 현재 숫자를 두 번째 그룹에 추가
        if (list2.size() < nums.length / 2) {
            list2.add(nums[index]);
            backtrack(nums, index + 1, list1, list2);
            list2.remove(list2.size() - 1);
        }
    }

    // 위 풀이는 주어진 예제는 통과했지만 테스트케이스에서 시간을 초과하였다.. 최적화 방안을 고민해보자.
    public int minimumDifferenceOptimize(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int n = nums.length / 2;
        int[] list1 = Arrays.copyOfRange(nums, 0, n);
        int[] list2 = Arrays.copyOfRange(nums, n, nums.length);

        List<List<Integer>> sums1 = generateSums(list1);
        List<List<Integer>> sums2 = generateSums(list2);

        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i <= n; i++) {
            System.out.println(i+"번째 실행");

            Collections.sort(sums2.get(i));
            System.out.println("i번째 원소가 정렬된 sums2" + sums2);
            for (int sum : sums1.get(i)) {
                System.out.println("i번째 sums1 = " + sum);

                int target = (total - 2 * sum) / 2;
                System.out.println("타겟 =" + target);

                int idx = Collections.binarySearch(sums2.get(n - i), target);
                System.out.println("이진 탐색으로 찾은 인덱스값 =" + idx);

                if (idx < 0) idx = -idx - 1; // 타겟이 리스트에 존재하지 않는 경우이므로 타겟보다 바로 큰 원소를 바라보도록 설정

                if (idx < sums2.get(n - i).size()) { // 타겟이 리스트에 존재하는 경우
                    int curDiff = Math.abs(total - 2 * (sum + sums2.get(n - i).get(idx)));
                    minDiff = Math.min(minDiff, curDiff);
                }
                if (idx > 0) { // 타겟이 리스트에 존재하는 경우
                    int curDiff = Math.abs(total - 2 * (sum + sums2.get(n - i).get(idx - 1)));
                    minDiff = Math.min(minDiff, curDiff);
                }
            }
        }
        return minDiff;
    }

    private List<List<Integer>> generateSums(int[] nums) {
        int n = nums.length;
        List<List<Integer>> sums = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            sums.add(new ArrayList<>());
        }
        sums.get(0).add(0); // 빈 부분집합

        for (int num : nums) {
            for (int i = n; i >= 1; i--) {
                for (int prevSum : sums.get(i - 1)) {
                    sums.get(i).add(prevSum + num);
                }
            }
        }
        return sums;
    }

    public static void main(String[] args) {
        PartitionArray solution = new PartitionArray();
        int[] nums = {3,9,7,2};
        System.out.println(solution.minimumDifferenceOptimize(nums));
    }
}
