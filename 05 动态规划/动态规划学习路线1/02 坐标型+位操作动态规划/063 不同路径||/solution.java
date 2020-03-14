class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        // 处理边界条件
        if(m == 0 || n == 0) return 0;
        int[][] memo = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                //障碍物直接设置为 memo = 0直接continue跳过
                if(obstacleGrid[i][j] == 1){
                    memo[i][j] = 0;
                    continue;
                }
                //第一行或者第一列因为是起始点直接是1
                if(i == 0 && j == 0){
                    memo[i][j] = 1;
                    continue;
                }
                // 其余情况 默认为0 用i，j是否大于0 控制加减
                memo[i][j] = 0;
                if(i > 0){
                    memo[i][j] += memo[i-1][j];
                }
                if(j > 0){
                    memo[i][j] += memo[i][j-1];
                }
            }
        }
        return memo[m-1][n-1];
    }
}