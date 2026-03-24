import java.util.*;

public class Provinces {

    public static int Solution(ArrayList<ArrayList<Integer>> adj, int n) {
        int count = 0;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(i, visited, adj);
                count++;
            }
        }
        return count;
    }

    public static void bfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node] = true;

        while (!q.isEmpty()) {
            int front = q.remove();

            for (int j = 0; j < adj.size(); j++) {
                if (adj.get(front).get(j) == 1 && !visited[j]) {
                    q.add(j);
                    visited[j] = true;
                }
            }
        }
    }

    public static void main(String args[]) {

        int n = 4; // number of cities

        // Hardcoded adjacency matrix
        int matrix[][] = {
            {1, 1, 0, 0},
            {1, 1, 0, 0},
            {0, 0, 1, 1},
            {0, 0, 1, 1}
        };

        // Converting matrix to ArrayList<ArrayList<Integer>>
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(matrix[i][j]);
            }
            adj.add(row);
        }

        int provinces = Solution(adj, n);
        System.out.println("Number of Provinces: " + provinces);
    }
}