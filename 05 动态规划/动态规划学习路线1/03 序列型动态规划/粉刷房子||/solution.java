//优化只记录最小值和次小值
class Solution {
    public int minCostII(int[][] costs) {
        int n = costs.length;
        if(n == 0) return 0;
        int k = costs[0].length;
        int[][] f = new int[n+1][k];
        int min1;// 最小值
        int min2;// 次小值
        int id1 = -1;
        int id2 = -1;
        //初始化
        for(int i = 0; i < k; i++){
            f[0][i] = 0;
        }
        //注意<=n
        for(int i = 1; i <= n; i++){
            min1 = min2 = Integer.MAX_VALUE;
            for(int j = 0; j < k; j++){
                if(min1 > f[i - 1][j]){
                    min2 = min1;
                    id2 = id1;
                    min1 = f[i - 1][j];
                    id1 = j;
                }else{
                    if(min2 > f[i - 1][j]){
                        min2 = f[i - 1][j];
                        id2 = j;
                    }
                }
            }
            for(int j = 0; j < k; j++){
                f[i][j] = costs[i-1][j];
                if(j != id1){
                    f[i][j] += min1;
                }
                //k == 1 情况下要判断
                if( j == id1 && min2 != Integer.MAX_VALUE){
                    f[i][j] += min2;
                }else{
                    f[i][j] += 0;
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for(int j = 0; j < k; j++){
            res = Math.min(res, f[n][j]);
        }            
        return res;
    }
}