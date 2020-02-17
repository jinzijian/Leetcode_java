class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        helper(res, new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }
    public void helper(List<List<Integer>> res, List<Integer> list, int[] nums, boolean[] used){
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(used[i]) continue;
            list.add(nums[i]);
            used[i] = true;
            helper(res,list,nums, used);
            used[i] = false;
            list.remove(list.size()-1);
        }
    }
}