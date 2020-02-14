class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        helper(res, new ArrayList<>(), nums, 0);
        return res;
    }
    public void helper(List<List<Integer>> res, List<Integer> list, int[] nums, int index){
        res.add(new ArrayList<>(list));
        for(int i = index; i < nums.length; i++){
            if(i>index && nums[i] == nums[i-1]) continue;
            // 为什么i要大于index
            list.add(nums[i]);
            helper(res,list,nums,i+1);
            list.remove(list.size()-1);
        }
    }
}