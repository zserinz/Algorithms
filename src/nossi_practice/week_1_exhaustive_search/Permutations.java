package nossi_practice.week_1_exhaustive_search;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    // 풀이 1. 재귀 함수 사용
    public List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(new ArrayList<>(), nums, ans);
        return ans;
    }

    private void backtrack(List<Integer> curr, int[] nums, List<List<Integer>> ans) {
        // basecase : 최종 사이즈에 도달하면 정답 리스트에 추가하고 멈춰야 한다.
        if (curr.size() == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int num : nums) {
            // 기존에 이미 들어있던 값은 제외해야 한다.
            if (!curr.contains(num)) {
                curr.add(num);
                backtrack(curr, nums, ans);
                curr.remove(curr.size() - 1);
            }
        }
    }
}
