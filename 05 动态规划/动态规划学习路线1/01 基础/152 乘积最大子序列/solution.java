//分三种情况 nums[j] > 0 则a[j-1]越大越好 否则越小越好 或者aj本身
//所以需要同时保留最大最小值
class Solution {
    public int maxProduct(int[] nums) {
        if(nums == null) return 0;
        int n = nums.length;
        int[] f = new int[n];
        int[] g = new int[n];
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            f[i] = nums[i];
            //检查i是否大于等于1
            if(i > 0){
                f[i] = Math.max(f[i], Math.max(nums[i]*f[i-1], nums[i]*g[i-1]));
            }
            g[i] = nums[i];
            if(i > 0){
                g[i] = Math.min(g[i], Math.min(nums[i]*f[i-1], nums[i]*g[i-1]));
            }
            res = Math.max(res, f[i]);
        }
        return res;
    }
}