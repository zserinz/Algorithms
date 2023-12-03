package hash_table

/**
 * Design a HashMap without using any built-in hash table libraries.
 *
 * Implement the MyHashMap class:
 * MyHashMap() initializes the object with an empty map.
 * void put(int key, int value) inserts a (key, value) pair into the HashMap. If the key already exists in the map, update the corresponding value.
 * int get(int key) returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
 * void remove(key) removes the key and its corresponding value if the map contains the mapping for the key.
 */
class DesignHashMap {
    val nodes: Array<Node?> = arrayOfNulls(1000000)

    // 삽입
    fun put(key: Int, value: Int) {
        // 해싱 결과를 인덱스로 저장
        val index = key % nodes.size
        // 충돌이 없을 경우, 인덱스를 신규 생성 후, 바로 종료
        if (nodes[index] == null) {
            nodes[index] = Node(key, value)
            return
        }

        // 인덱스에 노드가 존재한다면, 연결 리스트로 처리
        var node = nodes[index]
        while (node != null) {
            // 동일한 키가 있다면 값을 업데이트 한 후, 종료
            if (node.key == key) {
                node.`val` = value
                return
            }
            // 다음 노드가 없다면, 종료
            if (node.next == null)
                break
            node = node.next
        }
        // 마지막 노드의 다음으로 연결
        node!!.next = Node(key,value)
    }

    // 조회
    fun get(key: Int): Int {
        // 해싱 결과를 인덱스로 저장
        val index = key % nodes.size
        // 해당 인덱스에 노드 자체가 존재하지 않으면 -1 리턴
        if (nodes[index] == null)
            return -1

        // 인덱스에 노드가 존재하면 일치하는 키 탐색
        var node = nodes[index]
        while (node != null) {
            // 동일한 키가 있다면 해당 키의 값을 리턴
            if (node.key == key) {
                return node.`val`
            }
            node = node.next
        }

        // 인덱스를 모두 순회해도 일치하는 키가 없다면 -1 리턴
        return -1
    }

    // 삭제
    fun remove(key: Int) {
        // 해싱 결과를 인덱스로 저장
        val index = key % nodes.size
        // 해당 인덱스에 노드가 없다면 바로 종료
        if (nodes[index] == null)
            return

        // 첫 번째 노드일 때, 삭제
        var node = nodes[index]
        if (node!!.key == key) {
            if (node.next == null)
                // 다음 노드가 없다면 해당 인덱스는 null 처리
                nodes[index] = null
            else
                // 다음 노드가 존재한다면 다음 노드를 해당 인덱스로 저장하여 삭제
                nodes[index] = node.next
        }

        // 연결 리스트 노드일 때 삭제 처리
        var prev = node
        while (node != null) {
            if (node.key == key) {
                // 이전 노드의 다음에 현재 노드의 다음을 연결하여 삭제
                prev!!.next = node.next
                return
            }
            // 노드를 한칸씩 이동
            prev = node
            node = node.next
        }
    }
}