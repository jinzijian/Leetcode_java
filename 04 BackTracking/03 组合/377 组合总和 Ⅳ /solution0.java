// 暴力递归回溯法——堆栈耗尽
class Solution {
    public int combinationSum4(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return 0;
        helper(res,new ArrayList<>(),nums,target);
        return res.size();
    }
    public void helper(List<List<Integer>> res, List<Integer> list, int[] nums, int target){
        if(target == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            list.add(nums[i]);
            helper(res, list, nums, target - nums[i]);
            list.remove(list.size()-1);
        }
    }
}