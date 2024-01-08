package nossi_practice.week_2_list_stack_queue_graph;

import java.util.Arrays;
import java.util.Comparator;
/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[][] indexedNums = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            indexedNums[i][0] = nums[i]; // 주어진 숫자값 저장
            indexedNums[i][1] = i; // 인덱스값 저장
        }

        // 값을 기준으로 오름차순 정렬
        Arrays.sort(indexedNums, Comparator.comparingInt(a -> a[0]));

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = indexedNums[left][0] + indexedNums[right][0];
            if (sum == target) {
                return new int[] {indexedNums[left][1], indexedNums[right][1]};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[] {-1, 1};
    }
}
