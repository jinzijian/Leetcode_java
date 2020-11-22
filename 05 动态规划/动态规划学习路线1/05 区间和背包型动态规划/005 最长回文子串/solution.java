// 动态规划法
class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++){
                if(i == j){
                    dp[i][j] = 1;
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        int[] res = new int[2];
        res[0] = 0;
        res[0] = 0;
        int maxlen = 1;
        for(int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) { 
                // i, j 没必要相遇所以是 < j
                if(s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = 0;
                }else{
                    // 这里是重点 长度2 需要特别处理
                    if(j - i + 1 <= 2) {
                        dp[i][j] = j - i + 1;
                    }else{
                        if(dp[i+1][j-1] != 0) {
                            dp[i][j] = dp[i+1][j-1] + 2;
                        }
                    }
                }
                if(dp[i][j] > maxlen) {
                    maxlen = dp[i][j];
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return s.substring(res[0], res[1] + 1);
    }
}