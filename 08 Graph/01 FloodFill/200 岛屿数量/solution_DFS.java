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
                    floodfill(grid, i, j);
                    res += 1;
                }
            }
        }
        return res;
    }
    private void floodfill(char[][] grid, int i, int j){
        if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == '0') return;
        grid[i][j] = '0';
        floodfill(grid, i + 1, j);
        floodfill(grid, i - 1, j);
        floodfill(grid, i, j+1);
        floodfill(grid, i, j-1);
    }
}