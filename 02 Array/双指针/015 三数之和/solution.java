class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length < 3) return res;
        // sort
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0) break;//去重
            if(i > 0 && nums[i] == nums[i-1]) continue;//去重
            int l = i + 1;
            int r = nums.length - 1;
            while( l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if(sum == 0){
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while(l < r && nums[l + 1] == nums[l]) l++;//去重
                    while(l < r && nums[r - 1] == nums[r]) r--;//去重
                    //切莫忘记
                    l++;
                    r--;
                }
                if(sum < 0) l++;
                if(sum > 0) r--;
            }
        }
        return res;
    }
}