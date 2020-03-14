//滚动数组法
//只开两行数组，空间优化
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if(m==0 || n == 0) return 0;
        //只开两行
        int[][] f = new int[2][n];
        // old now 处理
        int old, now = 0;
        for(int i = 0; i < m; i++){
            //不断交换 now永远等1-now
            old = now;
            now = 1 - now;
            //所有i的部分用now代替
            for(int j = 0; j < n; j++){
                if(i == 0 && j == 0){
                    f[now][j]  = grid[i][j];
                    continue;
                }
                int t = Integer.MAX_VALUE;
                if(i > 0){
                    t = Math.min(t, f[old][j]);
                }
                if(j > 0){
                    t = Math.min(t, f[now][j-1]);
                }
                f[now][j] = t + grid[i][j];
            }
        }
        //返回now
        return f[now][n-1];

    }
}