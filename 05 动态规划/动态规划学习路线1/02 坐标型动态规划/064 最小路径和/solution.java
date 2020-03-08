class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if(m==0 || n == 0) return 0;
        int[][] f = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 && j == 0){
                    f[i][j]  = grid[i][j];
                    continue;
                }
                int t = Integer.MAX_VALUE;
                if(i > 0){
                    t = Math.min(t, f[i-1][j]);
                }
                if(j > 0){
                    t = Math.min(t, f[i][j-1]);
                }
                f[i][j] = t + grid[i][j];
            }
        }
        return f[m-1][n-1];

    }
}