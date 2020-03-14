//位运算一般用值做单位
//10001 右移变为 1000
class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        res[0] = 0;
        if(num == 0) return res;
        for(int i = 1; i < res.length; i++){
            res[i] = res[ i>> 1] + i%2; // i%2计算当前一位
        }
        return res;
    }
}