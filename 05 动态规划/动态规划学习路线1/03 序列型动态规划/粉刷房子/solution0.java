//同时第n-1栋各个颜色的最小花费--另开一维数组
//转移方程 f[i][0] = min{f[i-1][1]+cost[i-1][0], f[i-1][2] + cost[i-1][0]}
class Solution {
    public int minCost(int[][] costs) {
        int n = costs.length;
        if(n == 0) return 0;
        //sequence type初始化要从零开始
        int[][] f = new int[n+1][3];
        f[0][0] = 0;
        f[0][1] = 0;
        f[0][2] = 0;
        //开始循环
        for(int i = 1; i < n + 1; i++){
            f[i][0] = Math.min(f[i-1][1]+ costs[i-1][0], f[i-1][2]+ costs[i-1][0]);
            f[i][1] = Math.min(f[i-1][0]+ costs[i-1][1], f[i-1][2]+ costs[i-1][1]);
            f[i][2] = Math.min(f[i-1][0]+ costs[i-1][2], f[i-1][1]+ costs[i-1][2]);
        }
        return Math.min(f[n][0], Math.min(f[n][1], f[n][2]));
    }
}