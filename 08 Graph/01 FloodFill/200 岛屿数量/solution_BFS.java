class Solution {
    private int m;
    private int n;
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        m = grid.length;
        n = grid[0].length;
        int res = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    floodfillbfs(grid, i, j);
                    res += 1;
                }
            }
        }
        return res;
    }
    private void floodfillbfs(char[][] grid, int x, int y){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x * n + y);
        grid[x][y] = '0';
        while(!queue.isEmpty()){
            int cur = queue.poll();
            int i = cur / n;
            int j = cur % n;
           if(i > 0 && grid[i - 1][j] == '1'){
               queue.offer((i-1) * n + j);
               grid[i-1][j] = 0;
           }
           if(i < m - 1 && grid[i + 1][j] == '1'){
               queue.offer((i+1) * n + j);
               grid[i+1][j] = 0;
           }
           if(j > 0 && grid[i][j - 1] == '1'){
               queue.offer(i * n + j - 1);
               grid[i][j - 1] = 0;
           }
           if(j < n - 1 && grid[i][j + 1] == '1'){
               queue.offer(i * n + j + 1);
               grid[i][j + 1] = 0;
           }
        }
    }
}