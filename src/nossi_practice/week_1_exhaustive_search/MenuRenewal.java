package nossi_practice.week_1_exhaustive_search;

import java.util.*;

/**
 * 레스토랑을 운영하던 스카피는 코로나19로 인한 불경기를 극복하고자 메뉴를 새로 구성하려고 고민하고 있습니다.
 * 기존에는 단품으로만 제공하던 메뉴를 조합해서 코스요리 형태로 재구성해서 새로운 메뉴를 제공하기로 결정했습니다. 어떤 단품메뉴들을 조합해서 코스요리 메뉴로 구성하면 좋을 지 고민하던 "스카피"는 이전에 각 손님들이 주문할 때 가장 많이 함께 주문한 단품메뉴들을 코스요리 메뉴로 구성하기로 했습니다.
 * 단, 코스요리 메뉴는 최소 2가지 이상의 단품메뉴로 구성하려고 합니다. 또한, 최소 2명 이상의 손님으로부터 주문된 단품메뉴 조합에 대해서만 코스요리 메뉴 후보에 포함하기로 했습니다.
 *
 * 예를 들어, 손님 6명이 주문한 단품메뉴들의 조합이 다음과 같다면,
 * (각 손님은 단품메뉴를 2개 이상 주문해야 하며, 각 단품메뉴는 A ~ Z의 알파벳 대문자로 표기합니다.)
 *
 * 손님 번호	주문한 단품메뉴 조합
 * 1번 손님	A, B, C, F, G
 * 2번 손님	A, C
 * 3번 손님	C, D, E
 * 4번 손님	A, C, D, E
 * 5번 손님	B, C, F, G
 * 6번 손님	A, C, D, E, H
 * 가장 많이 함께 주문된 단품메뉴 조합에 따라 "스카피"가 만들게 될 코스요리 메뉴 구성 후보는 다음과 같습니다.
 *
 * 코스 종류	메뉴 구성	설명
 * 요리 2개 코스	A, C	1번, 2번, 4번, 6번 손님으로부터 총 4번 주문됐습니다.
 * 요리 3개 코스	C, D, E	3번, 4번, 6번 손님으로부터 총 3번 주문됐습니다.
 * 요리 4개 코스	B, C, F, G	1번, 5번 손님으로부터 총 2번 주문됐습니다.
 * 요리 4개 코스	A, C, D, E	4번, 6번 손님으로부터 총 2번 주문됐습니다.
 * [문제]
 * 각 손님들이 주문한 단품메뉴들이 문자열 형식으로 담긴 배열 orders, "스카피"가 추가하고 싶어하는 코스요리를 구성하는 단품메뉴들의 갯수가 담긴 배열 course가 매개변수로 주어질 때, "스카피"가 새로 추가하게 될 코스요리의 메뉴 구성을 문자열 형태로 배열에 담아 return 하도록 solution 함수를 완성해 주세요.
 */
public class MenuRenewal {
    Map<String, Integer> map;
    int m;

    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();

        for (int c : course) { // 선정하고 싶은 코스 개수만큼 진행
            map = new HashMap<>();
            m = c;
            for (String order : orders) { // 각 주문마다 조합을 조회하고 등장 횟수를 기록
                char[] orderArray = order.toCharArray();
                Arrays.sort(orderArray); // 중복 조합을 피하기 위해 정렬처리 (AB=BA)
                backtrack(orderArray, 0, new StringBuilder());
            }

            // 가장 있기 있는 메뉴 조합 찾기
            List<String> popularList = new ArrayList<>();
            int max = 0;
            for (String key : map.keySet()) {
                if (map.get(key) > max) { // 주문된 횟수가 최대값보다 많으면 추가
                    max = map.get(key);
                    popularList = new ArrayList<>(); // 그냥 추가하면 오류.. -> 초기화해서 다시 최대 조합만 추가
                    popularList.add(key);
                } else if (map.get(key) == max) {
                    popularList.add(key);
                }
            }

            if (max > 1) answer.addAll(popularList); // 최소 2명의 손님으로부터 주문된 조합만 후보로 고려하여 answer에 최종 추가
        }

        Collections.sort(answer); // 알파벳 순으로 정렬
        return answer.toArray(new String[0]);
    }

    void backtrack(char[] orderArray, int idx, StringBuilder sb) {
        // basecase 현재 조합의 길이가 코스 요리 메뉴 개수와 동일할때
        if (sb.length() == m) {
            String cmb = sb.toString();
            // 등장횟수 없으면 0, 있으면 + 1 / 최초 > map.put("AB",1), 기존에 있었으면 > map.put("AB", map.get("AB") + 1) 기존 횟수를 조회해서 + 1
            map.put(cmb, map.getOrDefault(cmb, 0) + 1);
            return;
        }

        for (int i = idx; i < orderArray.length; ++i) {
            sb.append(orderArray[i]);
            backtrack(orderArray, i + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
