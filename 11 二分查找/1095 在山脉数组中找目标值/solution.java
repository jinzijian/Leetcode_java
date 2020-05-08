class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int size = mountainArr.length();
        int left;
        int right;
        int mid;
        int top;
        //找峰顶
        left = 0;
        right = size - 1;
        while(left + 1 < right) {
            mid = left + (right - left) / 2;
            //先提前存下 不然容易超次数
            int peek = mountainArr.get(mid);
            int peek1 = mountainArr.get(mid - 1);
            int peek2 = mountainArr.get(mid + 1);
            if(peek > peek1 && peek > peek2){
                top = mid;
            }
            if(peek < peek2) left = mid + 1;
            else{
                right = mid;
            }
        }
        if(mountainArr.get(left) > mountainArr.get(right)){
            top = left;
        }else{
            top = right;
        }
        if(mountainArr.get(top) == target) return top;
        //在递增区间找
        left = 0;
        right = top - 1;
        while(left + 1 < right) {
            mid = left + (right - left) / 2;
            if(mountainArr.get(mid) == target){
                return mid;
            } 
            if(mountainArr.get(mid) < target){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        if(mountainArr.get(left) == target) return left;
        if(mountainArr.get(right) == target) return right;
        //在递减区间找
        left = top + 1;
        right = size - 1;
        while(left + 1 < right){
            mid = left + (right - left) / 2;
            if(mountainArr.get(mid) == target) return mid;
            if(mountainArr.get(mid) < target) right = mid - 1;
            else{
                left = mid;
            }
        }
        if(mountainArr.get(left) == target) return left;
        if(mountainArr.get(right) == target) return right;
        return -1;
    }
}