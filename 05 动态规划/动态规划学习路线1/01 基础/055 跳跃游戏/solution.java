class Solution {
    public boolean canJump(int[] nums) {
        boolean[] memo = new boolean[nums.length];
        memo[0] = true;
        for(int i = 1; i < nums.length; i++){
            memo[i] = false;
            for(int j = 0; j < i; j++){
                if(memo[j] && j + nums[j] >= i){
                    memo[i] = true;
                    break;
                }
            }
        }
        return memo[nums.length - 1];
    }
}