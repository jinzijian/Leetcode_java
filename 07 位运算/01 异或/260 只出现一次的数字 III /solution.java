class Solution {
    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        if (nums == null || nums.length < 2) {
            return res;
        }
        int xorres = 0;
        for(int x : nums){
            xorres ^=  x;
        }
        int tmp = 1;
        while(true){
            if((xorres & 1) == 1) break;
            tmp = tmp << 1;
            xorres = xorres >> 1;
        }
        for(int y : nums){
            if((y & tmp) == 0){
                res[0] ^= y; 
            }
            else{
                res[1] ^= y; 
            }
        }
        return res;
    }
}