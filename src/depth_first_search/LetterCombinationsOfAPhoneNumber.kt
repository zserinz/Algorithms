package depth_first_search
/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
 *
 * A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 */
class LetterCombinationsOfAPhoneNumber {
    fun letterCombinations(digits: String): List<String> {
        val result: MutableList<String> = mutableListOf()
        if (digits.isEmpty())
            return result

        // 번호에 대응되는 숫자판 입력
        val dic: MutableMap<Char, List<Char>> = mutableMapOf(
            '0' to mutableListOf(),
            '1' to mutableListOf(),
            '2' to mutableListOf('a','b','c'),
            '3' to mutableListOf('d','e','f'),
            '4' to mutableListOf('g','h','i'),
            '5' to mutableListOf('j','k','l'),
            '6' to mutableListOf('m','n','o'),
            '7' to mutableListOf('p','q','r','s'),
            '8' to mutableListOf('t','u','v'),
            '9' to mutableListOf('w','x','y','z')
        )

        fun dfs(index: Int, path: StringBuilder) {
            //이미 끝까지 탐색한 경우에 결과를 저장하고 리턴
            if (path.length == digits.length) {
                result.add(path.toString())
                return
            }

            // 현재 자리 숫자에 해당하는 모든 문자열 탐색
            for (c in dic[digits[index]]!!) {
                // 현재 자리 +1, 지금까지 구성된 문자열 path 를 이용해서 DFS 실행
                dfs(index + 1, StringBuilder(path).append(c))
            }
        }

        dfs(0, StringBuilder())
        return result
    }
}