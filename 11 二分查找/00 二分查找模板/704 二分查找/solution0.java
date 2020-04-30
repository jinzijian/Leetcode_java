class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(target == nums[mid]) return mid;
            if(target < nums[mid]){
                right = mid - 1;
            }
            if(target > nums[mid]){
                left = mid + 1;
            }
        }
        return -1;
    }
}