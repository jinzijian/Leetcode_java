class Solution {
    //逐行使用二分法
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0) return false;
        for(int i = 0; i < matrix.length; i++){
            if(binarySearch(matrix[i], target)){
                return true;
            }else{
                continue;
            }
        }
        return false;
    }
    private boolean binarySearch(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while(left + 1 < right) {
            int mid = left + (right - left)/2;
            if(nums[mid] == target) return true;
            if(nums[mid] < target) left = mid;
            else{
                right = mid;
            }
        }
        if(nums[left] == target || nums[right] == target) return true;
        return false;
    }
}