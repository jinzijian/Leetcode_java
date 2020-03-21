class Solution {
    public int minCut(String s) {
        //记录回文串
        char[] ss = s.toCharArray();
        int n = ss.length;
        if(n == 0) return 0;
        boolean[][] isPalin = calcPalin(ss);
        int[] f = new int[n + 1];
        f[0] = 0;
        for (int i = 1; i <= n; i++){
            f[i] = Integer.MAX_VALUE;
            for(int j = 0; j < i; j++){
                if(isPalin[j][i-1]){
                    f[i] = Math.min(f[j] + 1, f[i]);
                }
            }
        }

        return f[n] - 1;
    }
    private boolean[][] calcPalin(char[] s){
        int n = s.length;
        int i, j, c;
        boolean[][] f = new boolean[n][n];
        for(i = 0; i < n; i++){
            for(j = 0; j < n; j++){
                f[i][j] = false;
            }
        }
        //odd
        for(c = 0; c < n; c++){
            i = j = c;
            while( i >= 0 && j < n && s[i] == s[j]){
                f[i][j] = true;
                i--;
                j++;
            }
        }
        //even
        for(c = 0; c < n-1; c++){
            i = c;
            j = c+1;
            while( i >= 0 && j < n && s[i] == s[j]){
                f[i][j] = true;
                i--;
                j++;
            }
        }
        return f;
    }
}