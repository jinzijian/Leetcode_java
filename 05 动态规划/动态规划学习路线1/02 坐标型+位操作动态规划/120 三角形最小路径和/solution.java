class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if(n == 0 || triangle == null) return 0;
        int[][] f = new int[n][n];
        List<Integer> start = triangle.get(0);
        f[0][0] = start.get(0);
        for(int i = 1; i < n; i++){
            f[0][i] = Integer.MAX_VALUE;
        }
        for(int i = 1; i < n; i++){
            for(int j = 0; j < n; j++){
                List<Integer> tmp = triangle.get(i);
                if(j == 0){
                    f[i][j] = f[i-1][j] + tmp.get(j);
                }
                if(j > 0 && j < i){
                    f[i][j] = Math.min(f[i-1][j-1], f[i-1][j]) + tmp.get(j);
                }
                if(j == i){
                    f[i][j]  = tmp.get(j) + f[i-1][j-1];
                }

            }
        } 
        int res = Integer.MAX_VALUE;
        for(int j = 0; j < n; j++){
            res = Math.min(res, f[n-1][j]);
        }
        return res;
    }
}