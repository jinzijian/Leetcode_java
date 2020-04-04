//参考https://leetcode-cn.com/problems/single-number-ii/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--31/
class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int i = 0; i < 32; i++){
            int count = 0;
            for(int j = 0; j < nums.length; j++){
                if((nums[j]>>i & 1 ) == 1){
                    count ++;
                }
            }
            if(count % 3 != 0){
                ans = ans | 1 << i;
            }
        }
        return ans;
    }
}