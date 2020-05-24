//本质上相当于进制转换
class Solution {
    public String convertToTitle(int n) {
        StringBuilder s = new StringBuilder();
        //StringBuilder相当于存string的List；
        while(n > 0) {
            //因为没有0；所以要补一位所以每次转换前要-1；
            n = n - 1;
            int c = n % 26;
            s.insert(0, (char)('A' + c));
            n = n / 26;
        }
        //转化为字符串最后
        return s.toString();
    }
}