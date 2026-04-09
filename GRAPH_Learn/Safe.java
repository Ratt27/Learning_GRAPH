import java.util.*;

public class Safe {

    public List<Integer> SafeNodes(int[][] graph) {

        int n = graph.length;

        // reverse graph
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[n];

        // build reversed graph
        for (int i = 0; i < n; i++) {
            for (int ele : graph[i]) {
                // original: i → ele
                // reverse: ele → i
                adj.get(ele).add(i);
                indegree[i]++;
            }
        }

        // Kahn's Algorithm
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        List<Integer> ans = new ArrayList<>();

        while (!q.isEmpty()) {
            int front = q.remove();
            ans.add(front);

            for (int ele : adj.get(front)) {
                indegree[ele]--;
                if (indegree[ele] == 0) {
                    q.add(ele);
                }
            }
        }

        // sort result (important for output format)
        Collections.sort(ans);

        return ans;
    }

    public static void main(String[] args) {

        Safe obj = new Safe();

        int[][] graph = {
            {1, 2},
            {2, 3},
            {5},
            {0},
            {5},
            {},
            {}
        };

        System.out.println(obj.SafeNodes(graph));
    }
}