//打印出路径的方法
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if(m==0 || n == 0) return 0;
        int[][] f = new int[m][n];
        //用pi记录上次是来自上（0）还是左（1）
        int[][] pi = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 && j == 0){
                    f[i][j]  = grid[i][j];
                    continue;
                }
                int t = Integer.MAX_VALUE;
                if(i > 0){
                    t = Math.min(t, f[i-1][j]);
                    if(t == f[i-1][j]){
                        pi[i][j] = 0;
                    }
                }
                if(j > 0){
                    t = Math.min(t, f[i][j-1]);
                    if(t == f[i][j-1]){
                        pi[i][j] = 1;
                    }
                }
                f[i][j] = t + grid[i][j];
            }
        }
        int[] path = new int[m+n-1];
        int x = m - 1;
        int y = n - 1;
        for(int p = 0; p < m+n-1; p++){
            path[p] = grid[x][y];
            if(pi[x][y] == 0){
                x--;
            }else{
                y--;
            }
        }
        for(int i = m+n-2; i >= 0; i--){
            System.out.println(path[i]);
        }
        return f[m-1][n-1];

    }
}