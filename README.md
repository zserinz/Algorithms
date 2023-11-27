# Algorithms
이 리포지토리에는 일반적인 알고리즘에 대한 저의 솔루션이 포함되어 있습니다. 기초적인 알고리즘에 대해 공부하고, 풀이 과정을 연습한 과정들이 있습니다.  
각 솔루션에는 Java 프로그램이 있으며 테스트를 거쳤습니다. 테스트 디렉토리에서 테스트를 실행하는 솔루션을 확인할 수 있습니다. 일부 문제는 TDD를 사용하여 해결했습니다.

## How to resolve the problems
![CleanShot 2023-03-26 at 23 28 31](https://user-images.githubusercontent.com/96467897/227782523-baf2e48a-7533-470a-873b-d8e20cddb245.png)
1. 문제 이해
    1. 문제 이해 과정은 매우 중요하다. 적어도 두 번 이상 읽고, 근본적인 문제를 발견하는 능력을 키우자.
    2. 문제를 이해해야 해결할 수 있음을 항상 기억하자.
2. 예제 생성
    1. 백문이 불여일견
    2. 일단 작동하는 예제를 하나 찾으면, 전체적인 풀이 방법을 떠올릴 수 있다.
3. 알고리즘 선정 및 설명
    1. 해당 알고리즘을 선정하는 단계를 설명할 수 있어야 한다.
4. 스켈레톤 코드 작성
    1. 스켈레톤 코드란 구현 없이 클래스, 메서드와 인터페이스를 정의하는 것을 의미한다.
    2. SOLID 원칙, DRY 원칙과 같은 프로그래밍의 기본 원칙을 준수하자.
5. 솔루션 코드 작성
    1. 솔루션 코드는 잘 알려진 [자바 코딩 스타일](https://google.github.io/styleguide/javaguide.html)을 준수하자.
    2. 솔루션의 핵심 구현을 완료한 뒤에는 코드의 견고성을 높이자.
        1. 예와 처리, 유효성 검사
    3. 문제의 모든 요구사항을 충족했고 올바른 데이터 타입을 사용했는지 확인하자.
6. 솔루션 테스트
    1. 이전에 생성한 예제에서 잘 동작한다는 사실을 확인하자.
    2. 내가 작성한 코드가 제대로 동작한다는 것을 증명하는 일은 매우 중요하다.

## Solved problems
### String
- [문자 뒤집기(FlipWord)](https://github.com/zserinz/Algorithms/blob/main/src/string/FlipWord.java)
- [지정된 문자 뒤집기(Flip specific word)](https://github.com/zserinz/Algorithms/blob/main/src/string/FlipSpecificWord.java)
- [회문 문자열(Palindrome)](https://github.com/zserinz/Algorithms/blob/main/src/string/Palindrome.java)
    - [문제 해결 조건 추가(Valid palindrome)](https://github.com/zserinz/Algorithms/blob/main/src/string/ValidPalindrome.java)
- [중복 문자 제거(Remove duplicate char)](https://github.com/zserinz/Algorithms/blob/main/src/string/RemoveDuplicateChar.java)

### Array
- [두 수의 합(Two sum)](https://github.com/zserinz/Algorithms/blob/main/src/array/TwoSum.kt)
- [빗물 트래핑(Trapping rain water)](https://github.com/zserinz/Algorithms/blob/main/src/array/TrappingRainWater.kt)
- [세 수의 합(Three sum)](https://github.com/zserinz/Algorithms/blob/main/src/array/ThreeSum.kt)
- [배열 파티션(Array partition)](https://github.com/zserinz/Algorithms/blob/main/src/array/ArrayPartition.kt)
- [자신을 제외한 배열의 곱(Product of array except self)](https://github.com/zserinz/Algorithms/blob/main/src/array/ProductOfArrayExceptSelf.kt)
- [주식을 사고 팔기 좋은 시점(Best time to buy and sell stock)](https://github.com/zserinz/Algorithms/blob/main/src/array/Stock.kt)

### Lined List
- [두 수의 덧셈(Add two numbers)](https://github.com/zserinz/Algorithms/blob/main/src/linkedList/AddTwoNumbers.kt)
- [두 정렬 리스트의 병합(Merge two sorted lists)](https://github.com/zserinz/Algorithms/blob/main/src/linkedList/MergeTwoSortedLists.kt)
- [팰린드롬(Palindrome linked list)](https://github.com/zserinz/Algorithms/blob/main/src/linkedList/PalindromeLinkedList.kt)
- [홀짝 연결 리스트(Odd even linked list)](https://github.com/zserinz/Algorithms/blob/main/src/linkedList/OddEvenLinkedList.kt)
- [역순 연결 리스트 1(Revers linked list 1)](https://github.com/zserinz/Algorithms/blob/main/src/linkedList/ReverseLinkedListI.kt)
- [역순 연결 리스트 2(Revers linked list 2)](https://github.com/zserinz/Algorithms/blob/main/src/linkedList/ReverseLinkedListII.kt)
- [페어의 노드 스왑(Swap nodes in pairs)](https://github.com/zserinz/Algorithms/blob/main/src/linkedList/SwapNodesInPairs.kt)

### Recursive
- [로봇 경로 탐색(Robot grid map)](https://github.com/zserinz/Algorithms/blob/main/src/recursive/RobotGridMap.java)
- [하노이의 탑(Hanoi towers)](https://github.com/zserinz/Algorithms/blob/main/src/recursive/HanoiTowers.java)
- [요세푸스 문제(Josephus)](https://github.com/zserinz/Algorithms/blob/main/src/recursive/Josephus.java)
- [최대 영역(Biggest color spots)](https://github.com/zserinz/Algorithms/blob/main/src/recursive/BiggestColorSpots.java)
