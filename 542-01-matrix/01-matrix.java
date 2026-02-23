import java.util.*;

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        
        int rows = mat.length;
        int cols = mat[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        
        // Step 1: Add all 0s to queue, mark 1s as -1
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    mat[i][j] = -1; // mark unvisited
                }
            }
        }
        
        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        
        // Step 2: BFS
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            
            for (int[] dir : directions) {
                int newRow = cell[0] + dir[0];
                int newCol = cell[1] + dir[1];
                
                if (newRow >= 0 && newRow < rows &&
                    newCol >= 0 && newCol < cols &&
                    mat[newRow][newCol] == -1) {
                    
                    mat[newRow][newCol] = mat[cell[0]][cell[1]] + 1;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }
        
        return mat;
    }
}