class Solution {
    public int numSquares(int n) {
        int[] f = new int[n+1];
        f[0] = 0;
        for(int i = 1; i <= n; i++){
            f[i] = Integer.MAX_VALUE;
            //注意j * j <= i;
            for(int j = 1; j*j <= i; j++){
                f[i] = Math.min(f[i], f[i-j*j] + 1);
            }
        }
        return f[n];
    }
}