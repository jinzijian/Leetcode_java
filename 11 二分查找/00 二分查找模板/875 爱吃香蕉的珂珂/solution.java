//二分查找法综合题
class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        int left = 1;
        int right = findMax(piles);
        while(left < right){
            int mid = left + (right - left) / 2;
            if(calculateSum(mid, piles) > H){
                left = mid + 1;
            }else{
                //用else判断什么不是解
                //把解包含进来
                right = mid;
            }
        }
        return left;
    }
    private int findMax(int[] piles){
        int max = 0;
        for(int i = 0; i < piles.length; i++){
            max = Math.max(max, piles[i]);
        }
        return max;
    }
    private int calculateSum(int k, int[] piles){
        int sum = 0;
        for(int i = 0; i < piles.length; i++){
            int time = (piles[i] + k - 1) / k;
            sum += time;
        }
        return sum;
    }
}