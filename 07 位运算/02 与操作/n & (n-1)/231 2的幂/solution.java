/** 
2 10
4 100
8 1000
16 10000

16 10000
15 01111
16 & 15 = 0
**/
class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0) return false;
        long x = (long) n;
        return (x & (x-1)) == 0;
    }
}