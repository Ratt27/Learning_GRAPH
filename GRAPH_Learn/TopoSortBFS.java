// TOPOLOGICAL SORT
// always take place in a directed graph
//DAG
// using BFS---> KAHN'S ALGO
// Cyclic graph not allowed
// the node which has  no incomning can be made the starting node

// here  we will be using BFS-->
 // the node where maximum edges are coming--> should be at the end


 

import java.util.*;

public class TopoSortBFS {

    public static void topoSort(int[][] adj) {
        int n = adj.length;

        // Step 1: Calculate indegree
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            for (int v : adj[i]) {
                indegree[v]++;
            }
        }

        // Step 2: Add all nodes with indegree 0 to queue
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        // Step 3: BFS
        List<Integer> topo = new ArrayList<>();

        while (!q.isEmpty()) {
            int node = q.remove();
            topo.add(node);

            for (int v : adj[node]) {
                indegree[v]--;
                if (indegree[v] == 0) {
                    q.add(v);
                }
            }
        }

        // Step 4: Check cycle
        if (topo.size() != n) {
            System.out.println("Cycle detected! Topological sort not possible.");
        } else {
            System.out.println("Topological Order:");
            for (int x : topo) {
                System.out.print(x + " ");
            }
        }
    }

    public static void main(String[] args) {

        // Example DAG
        int[][] adj = {
            {1, 2},  // 0 → 1,2
            {3},     // 1 → 3
            {3},     // 2 → 3
            {}       // 3
        };

        topoSort(adj);
    }
}