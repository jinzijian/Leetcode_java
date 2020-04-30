//多源bfs
class Solution {
    private int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public int[][] updateMatrix(int[][] matrix) {
        int m  = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] res = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    res[i][j] = 0;
                    visited[i][j] = true;
                }
            }
        }
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            for(int i = 0; i < 4; i++){
                int newx = x + directions[i][0];
                int newy = y + directions[i][1];
                if(newx >= 0 && newx < m && newy >= 0 && newy < n && !visited[newx][newy]){
                    res[newx][newy] = res[x][y] + 1;
                    queue.offer(new int[]{newx, newy});
                    visited[newx][newy] = true;
                }
            }
        }
        return res;

    }
}