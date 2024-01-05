package nossi_practice.week_1_exhaustive_search;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    // 풀이 1
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, new ArrayList<>(), n, k, result);
        return result;
    }
    private void backtrack(int start, List<Integer> path, int n, int k, List<List<Integer>> result) {
        // 조합이 완성된 경우 결과에 추가
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }

        // 가능한 모든 숫자에 대해 반복
        for (int i = start; i <= n; i++) {
            path.add(i);
            backtrack(i + 1, path, n, k, result);
            path.remove(path.size() - 1); // 맨 마지막 요소를 제거하여 계속 새로운 조합이 완성될 수 있도록 한다.
        }
    }
}
