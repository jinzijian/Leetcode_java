//双指针 day1 《 day2 1买2卖 否则不买
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n == 0 || n == 1) return 0;
        int day1 = 0;
        int day2 = 1;
        int res = 0;
        while(day2 < n){
            if(prices[day2] > prices[day1]){
                res += prices[day2] - prices[day1];
            }
            day1 += 1;
            day2 += 1;
        }
        return res;
    }
}