class Solution {
    public int hammingDistance(int x, int y) {
        int tmp = x ^ y;
        int res = 0;
        //数出二进制中的1 用&操作 自己-1 & 自己
        while(tmp != 0){
            tmp &= (tmp - 1);
            res += 1;
        }
        return res;
    }
}