//把圈拆开
//分成两种 不偷第一家和不偷最后一家
class Solution {
    public int rob1(int[] nums) {
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
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return nums[0];
        int res = Integer.MIN_VALUE;
        int[] A = new int[n-1];
        for(int i = 0; i < n - 1; i++){
            A[i] = nums[i];
        }
        res = Math.max(res, rob1(A));
        for(int i = 0; i < n - 1; i++){
            A[i] = nums[i+1];
        }
        res = Math.max(res, rob1(A));
        return res;
    }
}