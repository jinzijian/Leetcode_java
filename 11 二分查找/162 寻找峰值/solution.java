class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1) return 0;
        int left = 1;
        int right = nums.length - 1;
        //边界情况有点特殊 先把边界情况单独处理下
        if(nums[0] > nums[1]) return 0;
        if(nums[right] > nums[right - 1]) return right;
        //再使用二分模板
        //使用画图 + 分情况讨论的方法
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) return mid;
            if(nums[mid] < nums[mid - 1] && nums[mid] < nums[mid + 1]){
                right = mid;
            }
            if(nums[mid] > nums[mid - 1] && nums[mid] < nums[mid + 1]){
                left = mid;
            }else{
                right = mid;
            }  
        }
        if(nums[left] > nums[right]) return left;
        return right;
    }
}