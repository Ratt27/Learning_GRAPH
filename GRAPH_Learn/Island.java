import java.util.*;

public class Island {

    // Pair class to store row and column
    static class Pair {
        int row, col;
        Pair(int r, int c) {
            row = r;
            col = c;
        }
    }

    public static int Solution(char[][] grid) {
        int m = grid.length;        // rows
        int n = grid[0].length;     // columns
        int count = 0;

        boolean[][] vis = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !vis[i][j]) {
                    bfs(i, j, grid, vis);
                    count++;
                }
            }
        }
        return count;
    }

    public static void bfs(int i, int j, char[][] grid, boolean[][] vis) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i, j));
        vis[i][j] = true;

        // Directions: Up, Down, Left, Right
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            Pair cur = q.remove();
            int row = cur.row;
            int col = cur.col;

            for (int k = 0; k < 4; k++) {
                int nr = row + dr[k];
                int nc = col + dc[k];

                // Boundary + unvisited land check
                if (nr >= 0 && nr < m && nc >= 0 && nc < n &&
                    grid[nr][nc] == '1' && !vis[nr][nc]) {
                    
                    vis[nr][nc] = true;
                    q.add(new Pair(nr, nc));
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] grid = {
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
        };

        System.out.println("Number of Islands: " + Solution(grid));
    }
}