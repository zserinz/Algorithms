package hash_table

import kotlin.math.max

/**
 * Given a string s, find the length of the longest substring
 *  without repeating characters.
 */
class LongestSubstringWithoutRepeatingCharacters {
    fun lengthOfLongestSubstring(s: String): Int {
        val used: MutableMap<Char, Int> = mutableMapOf()
        var maxLength = 0
        var left = 0
        var right = 0

        for (c in s.toCharArray()) {
            // 이미 등장했던 문자이고, 슬라이딩 윈도우의 안쪽에 있다면 left 위치를 한칸 앞으로 옮긴다.
            if (left <= used.getOrDefault(c, -1)) {
                left = used[c]!! + 1
            } else { // 아닌 경우, 최대 부분 문자열 길이를 업데이트 한다.
                maxLength = max(maxLength, right - left + 1)
            }

            // 현재 문자의 위치를 삽입한다.
            used[c] = right
            right++ // 오른쪽 포인터는 현재 문자의 위치에 맞춰 계속 증가시킨다.
        }
        return maxLength
    }
}