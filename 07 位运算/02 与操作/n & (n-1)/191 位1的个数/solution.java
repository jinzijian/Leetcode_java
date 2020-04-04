public class Solution {
    // you need to treat n as an unsigned value
    //利用掩码的方法
    public int hammingWeight(int n) {
        int result = 0;
        int mask = 1;
        for(int i = 0; i < 32; i++){
            if((n & mask) != 0){
                result += 1;
            }
            mask = mask << 1;
        }
        return result;
    }
}