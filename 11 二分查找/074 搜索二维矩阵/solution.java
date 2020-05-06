class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length - 1;
        int n = matrix[0].length - 1;
        //find row
        int start = 0;
        int end = m;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(matrix[mid][0] == target) return true;
            if(matrix[mid][0] < target){
                start = mid;
            }
            else{
                end = mid;
            }
        }
        int row;
        if(matrix[start][0] > target && matrix[end][0] > target) return false;
        if(matrix[end][0] == target) return true;
        if(matrix[end][0] > target){
            row = start;
        }else{
            row = end;
        }  
        //find column
        int left = 0;
        int right = n;
        while(left + 1 < right) {
            int mid = left + (right - left) / 2;
            if(matrix[row][mid] == target) return true;
            if(matrix[row][mid] > target) right = mid;
            else{
                left = mid;
            }
        }
        if(matrix[row][left] == target || matrix[row][right] == target) return true;
        return false;
 
    }
}