class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        memo[0] = 0;
        for(int i = 1; i <= amount; i++){
            memo[i] = Integer.MAX_VALUE;
            for(int k = 0; k < coins.length; k++){
                if(i >= coins[k] && memo[i - coins[k]] != Integer.MAX_VALUE){
                    memo[i] = Math.min(memo[i], memo[i - coins[k]] + 1);
                }
            }
        }
        if(memo[amount] == Integer.MAX_VALUE){
            return -1;
        }else{
            return memo[amount];
        }
    }
}