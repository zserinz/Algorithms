package nossi_practice.week_2_list_stack_queue_graph;

import java.util.List;

/**
 * There are n rooms labeled from 0 to n - 1 and all the rooms are locked except for room 0. Your goal is to visit all the rooms. However, you cannot enter a locked room without having its key.
 *
 * When you visit a room, you may find a set of distinct keys in it. Each key has a number on it, denoting which room it unlocks, and you can take all of them with you to unlock the other rooms.
 *
 * Given an array rooms where rooms[i] is the set of keys that you can obtain if you visited room i, return true if you can visit all the rooms, or false otherwise.
 */
public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        dfs(0, rooms, visited);

        for (boolean v : visited) {
            if (!v) return false;
        }

        return true;
    }

    private void dfs(int room, List<List<Integer>> rooms, boolean[] visited) {
        visited[room] = true;
        for (int key : rooms.get(room)) {
            if (!visited[key]) {
                dfs(key, rooms, visited);
            }
        }
    }
}
