//空间优化
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return nums[0];
        int old;
        int now;
        old = 0;
        now = nums[0];
        for(int i = 2; i <= n; i++){
            int t = Math.max(old + nums[i-1],now);
            old = now;
            now = t;
        }
        return now;
    }
}