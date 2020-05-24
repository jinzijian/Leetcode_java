class Solution {
    //26进制转十进制
    public int titleToNumber(String s) {
        int result = 0;
        int count = 0;
        for(int i  = s.length() - 1; i >= 0; i--) {
            //同样原因 +1;
            result += (s.charAt(i) - 'A' + 1) * Math.pow(26, count);
            count++;
        }
        return result;
    }
}