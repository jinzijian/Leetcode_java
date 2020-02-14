class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        /*要先排序*/
        Arrays.sort(nums);
        /*这里是调用所以需要创建实例*/
        helper(res, new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }
    public void helper(List<List<Integer>> res, List<Integer> list, int[] nums, boolean[] used){
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
        }
        for(int i = 0; i<nums.length; i++){
            /*used[i]被用过所以不再使用，或者整个大循环第二个和前一个重复也不再使用， 这几个限制详细原因*/
            if(used[i] || i>0 && nums[i] == nums[i-1] && !used[i-1]) continue;
            used[i] = true;
            list.add(nums[i]);
            helper(res,list,nums,used);
            /*记得要退回*/
            used[i] = false;
            list.remove(list.size()-1);
        }
    }
}