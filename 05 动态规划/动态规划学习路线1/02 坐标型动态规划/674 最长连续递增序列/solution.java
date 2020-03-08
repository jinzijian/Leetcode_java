class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        int[] f = new int[n];
        f[0] = 1;
        for(int i = 1; i < n; i++){
            if(nums[i] > nums[i-1]){
                f[i] = Math.max(1, f[i-1] + 1);
            }else{
                f[i] = 1;
            }
        }
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            res = Math.max(res, f[i]);
        }
        return res;
    }
}