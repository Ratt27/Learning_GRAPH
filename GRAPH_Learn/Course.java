//Course Schedule-->
import java.util.*;

public class Course {

    public static boolean canFinish(int n, int[][] pre) {

        // Create adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Indegree array
        int[] indegree = new int[n];

        // Build graph
        for (int i = 0; i < pre.length; i++) {
            int a = pre[i][0]; // course
            int b = pre[i][1]; // prerequisite

            adj.get(b).add(a); // b → a
            indegree[a]++;
        }

        // Queue for Kahn's Algorithm
        Queue<Integer> q = new LinkedList<>();

        // Add nodes with indegree 0
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int count = 0;

        // BFS (Topological Sort)
        while (!q.isEmpty()) {
            int front = q.remove();
            count++;

            for (int ele : adj.get(front)) {
                indegree[ele]--;
                if (indegree[ele] == 0) {
                    q.add(ele);
                }
            }
        }

        // If all courses processed → no cycle
        return count == n;
    }

    public static void main(String[] args) {

        int[][] pre = {
            {1, 0},
            {2, 0},
            {3, 1},
            {3, 2}
        };

        System.out.println(canFinish(4, pre));
    }
}