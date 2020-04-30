//二分搜索优化
class Solution {
    public int superEggDrop(int K, int N) {
        int[][] dp = new int[K+1][N+1];
        //初始化赋值
        for(int i = 0; i <= K; i++){
            for(int j = 0; j <= N; j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        //初始化0列1列
        for(int i = 0; i <= K; i++){
            dp[i][0] = 0;
            dp[i][1] = 1;
        }
        //初始化0行1行
        for(int j = 0; j <= N; j++){
            dp[1][j] = j;
            dp[0][j] = 0;
        }
        //转移方程————做选择
        for(int i = 2; i <= K; i++){
            for(int j = 2; j <= N; j++){
                int left = 1;
                int right = j;
                while(left < right){
                    int mid = left+(right - left + 1) / 2;
                    int breakCount = dp[i-1][mid - 1];
                    int notBreakCount = dp[i][j - mid];
                    if(breakCount > notBreakCount){
                        right = mid - 1;
                    }else{
                        left = mid;
                    }
                }
                dp[i][j] = Math.max(dp[i - 1][left - 1], dp[i][j - left]) + 1;
            }
        }
        return dp[K][N];
    }
}