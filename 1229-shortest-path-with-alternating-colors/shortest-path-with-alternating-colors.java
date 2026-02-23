import java.util.*;

class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        
        // Build graph with color
        Map<Integer, List<int[]>> graph = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        
        // 0 = red, 1 = blue
        for (int[] edge : redEdges) {
            graph.get(edge[0]).add(new int[]{edge[1], 0});
        }
        
        for (int[] edge : blueEdges) {
            graph.get(edge[0]).add(new int[]{edge[1], 1});
        }
        
        int[] answer = new int[n];
        Arrays.fill(answer, -1);
        
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][2];
        
        // Start from node 0 with no previous color (-1)
        queue.offer(new int[]{0, -1});
        
        int steps = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int node = current[0];
                int color = current[1];
                
                if (answer[node] == -1) {
                    answer[node] = steps;
                }
                
                for (int[] next : graph.get(node)) {
                    int nextNode = next[0];
                    int nextColor = next[1];
                    
                    // Alternate color condition
                    if (nextColor != color && !visited[nextNode][nextColor]) {
                        visited[nextNode][nextColor] = true;
                        queue.offer(new int[]{nextNode, nextColor});
                    }
                }
            }
            
            steps++;
        }
        
        return answer;
    }
}