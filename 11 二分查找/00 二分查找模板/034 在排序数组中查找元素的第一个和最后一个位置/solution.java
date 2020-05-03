/*
总结：
左边 mid = left + (right - left) / 2; left = mid + 1; right = mid;
右边 mid = left + (right - left + 1) / 2; right = mid - 1; left = mid;
*/
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) return new int[]{-1, -1};
        int[] res = new int[2];
        //find 2nd
        int left = 0;
        int right = nums.length - 1;//注意-1
        while(left < right){
            int mid = left + (right - left + 1) / 2;
            if(nums[mid] > target){
                right = mid - 1;
            }else{
                left = mid;
            }
        }
        if(nums[left] != target){
            res[1] = -1;
        }else{
            res[1] = left;
        }
        //find 1st
        left = 0;
        right = nums.length - 1;//注意-1
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        if(nums[left] != target){
            res[0] = -1;
        }else{
            res[0] = left;
        }
        return res;
    }
}