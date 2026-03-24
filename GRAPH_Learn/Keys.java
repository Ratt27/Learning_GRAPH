import java.util.*;

public class Keys {

    public static boolean Solution(List<List<Integer>> adj) {
        int n = adj.size();
        boolean[] visited = new boolean[n];
        visited[0] = true; // start from room 0
        bfs(0, adj, visited);

        for (boolean ele : visited) {
            if (ele == false)
                return false;
        }
        return true;
    }

    public static void bfs(int start, List<List<Integer>> adj, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            int front = q.remove();
            for (int ele : adj.get(front)) {
                if (!visited[ele]) {
                    visited[ele] = true;
                    q.add(ele);
                }
            }
        }
    }

    public static void main(String args[]) {

        // Hardcoded input:
        // Room 0 → keys for 1,2
        // Room 1 → key for 2
        // Room 2 → key for 3
        // Room 3 → no keys

        List<List<Integer>> rooms = new ArrayList<>();

        rooms.add(Arrays.asList(1, 2)); // Room 0
        rooms.add(Arrays.asList(2));    // Room 1
        rooms.add(Arrays.asList(3));    // Room 2
        rooms.add(new ArrayList<>());   // Room 3

        boolean canVisitAll = Solution(rooms);

        if (canVisitAll)
            System.out.println("True — All rooms can be visited");
        else
            System.out.println("False — All rooms cannot be visited");
    }
}