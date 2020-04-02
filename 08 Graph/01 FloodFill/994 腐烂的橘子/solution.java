//多源bfs 和 286 类似
class Solution {
    private static final List<int[]> DIRECTIONS = Arrays.asList(
            new int[] { 1,  0},
            new int[] {-1,  0},
            new int[] { 0,  1},
            new int[] { 0, -1}
    );
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid[0] == null) return -1;
        int m = grid.length;
        int n = grid[0].length;
        if(m == 0 || n == 0) return -1;
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2) queue.offer(new int[] {i , j});
            }
        }
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int[] d : DIRECTIONS){
                int r = cur[0] + d[0];
                int c = cur[1] + d[1];
                if(r < 0 || c < 0 || r >= m || c >= n || grid[r][c] != 1) continue;
                grid[r][c] = grid[cur[0]][cur[1]] + 1;
                queue.offer(new int[] {r, c});
            }
        }
        int res = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1) return -1;
                if(grid[i][j] == 2 ||  grid[i][j] == 0) continue;
                res = Math.max(res, grid[i][j]);
            }
        }
        if(res == 0) return res;
        return res - 2;
        
    }
}