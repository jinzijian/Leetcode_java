// 二分法模板总结
//left = mid right = mid - 1;向下取整 mid = left + (right - left + 1)/2
// left = mid + 1 right = mid; 向上取整 mid = left + (right - left )/2
class Solution {
    public int mySqrt(int x) {
        if(x == 0) return 0;
        if(x == 1) return 1;
        int left = 1;
        int right = x / 2 ;
        while(left < right){
            int mid = left + (right - left + 1) / 2;
            if(mid == x / mid) return mid;
            if(mid > x / mid){
                right = mid - 1;
            }
            if(mid < x / mid){
                left = mid;
            }
        }
        return left;
    }
}