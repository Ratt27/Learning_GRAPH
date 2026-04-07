import java.util.*;

public class Bipartite {
    static Boolean ans;

    public void bfs(int i, int[][] adj, int[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);

        while (q.size() > 0) {
            int front = q.remove();
            int color = visited[front];

            for (int ele : adj[front]) {
                if (visited[ele] == color) { // same color → not bipartite
                    ans = false;
                    return;
                }

                if (visited[ele] == -1) {
                    visited[ele] = 1 - color;
                    q.add(ele);
                }
            }
        }
    }

    public Boolean isBipartite(int[][] adj) {
        ans = true;
        int n = adj.length;
        int[] visited = new int[n];
        Arrays.fill(visited, -1);

        for (int i = 0; i < n; i++) {
            if (visited[i] == -1) {
                visited[i] = 0;
                bfs(i, adj, visited);
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        Bipartite obj = new Bipartite();

        // Example graph (Bipartite)
        int[][] adj = {
            {1, 3},    // 0
            {0, 2},    // 1
            {1, 3},    // 2
            {0, 2}     // 3
        };

        Boolean result = obj.isBipartite(adj);

        if (result) {
            System.out.println("Graph is Bipartite");
        } else {
            System.out.println("Graph is NOT Bipartite");
        }
    }
}