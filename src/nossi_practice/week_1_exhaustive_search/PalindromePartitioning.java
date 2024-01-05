package nossi_practice.week_1_exhaustive_search;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every
 * substring
 *  of the partition is a
 * palindrome
 * . Return all possible palindrome partitioning of s.
 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int start, List<String> palindrome, List<List<String>> result) {
        //basecase 시작 인덱스가 길이와 같아지는 순간 더이상 확인할 문자가 없으므로 종료
        if (start == s.length()) {
            result.add(new ArrayList<>(palindrome));
            return;
        }

        for (int end = start + 1; end <= s.length(); end++) {
            if (isPalindrome(s, start, end - 1)) {
                palindrome.add(s.substring(start, end)); // 팰린드롬인 경우 추가
                backtrack(s, end, palindrome, result);
                palindrome.remove(palindrome.size() - 1); // 이전 상태로 복원
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) { // 절반
            // 양쪽 끝부터 확인해 나간다.
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}

