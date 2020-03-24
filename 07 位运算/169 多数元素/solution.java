//位运算法,统计每个数字每一位0，1出现的次数，如果某一位1出现的次数多则该位为1，0同理；
//最后按为统计出来的数就是众数
class Solution {
    public int majorityElement(int[] nums) {
        int res = 0;
        int len = nums.length;
        for(int i = 0; i < 32; i++){
            int ones = 0;
            int zeros = 0;
            for(int j = 0; j < len; j++){
                if(ones > len/2 || zeros > len/2) break;
                if((nums[j] & (1 << i)) != 0) ones++;
                else zeros++;
            }
            if(ones > zeros){
                res = res | (1 << i);
            }
        }
        return res;
    }
}