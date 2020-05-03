class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int last = nums.length - 1;
        int right = nums.length - 1;
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == nums[last]){
                left = mid;
            }
            else if(nums[mid] < nums[last]){
                right = mid;
            }else{
                left = mid;
            }  
        }
        if(nums[left] < nums[right]){
            return nums[left];
        }else{
            return nums[right];
        }
    }
}