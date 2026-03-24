// whether there is path or not-->
// edges are given in bidierectionl  way--> its 2d matrix
//  here we have to make array of list/ adjacency list-->


import java.util.*;
public class Validpath
{
public static boolean Solution( int n,int[][] edges,int start, int end)
{

 if(start==end) return true;
// here we are creating an adjacenecy list
List<List<Integer>> adj= new ArrayList<>();

for(int i=0;i<n;i++)
{
// now we will  make empty list in each index of Adjacency list-->
List<Integer> list= new ArrayList<>();
adj.add(list);
}

for(int i=0;i<edges.length;i++)
{
int a= edges[i][0];
int b= edges[i][1];

adj.get(a).add(b);
adj.get(b).add(a);

}
 boolean[]  vis= new boolean[n];
 vis[start]= true;
bfs(start, adj, vis);
return vis[end];

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


public static void  main(String args[])
{
Scanner sc= new Scanner(System.in);
System.out.println("enter the no of nodes");


int n= sc.nextInt();
int[][] edges=  new int[n][n];

edges[0][0]=0;
edges[0][1]=1;
edges[1][0]=4;
edges[1][1]=1;
edges[2][0]=1;
edges[2][1]=2;
edges[3][0]=2;
edges[3][1]=3;

System.out.println("enter start and end node");
int start=sc.nextInt();
int end=sc.nextInt();

System.out.println(Solution(n,edges,start,end));

}
}