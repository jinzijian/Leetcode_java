class Solution {
    public List<List<Integer>> permute(int[] nums) {
        /* 创建res结果 */
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0){
            return res;
        }
        /* 确定helper函数需要传入的参数 */
        /* res 是最终结果肯定要传入 */
        /* 当前小list需要传入一个空的*/
        /* 数组nums需要传入*/
        helper(res, new ArrayList<>(), nums);
        return res;
    }
    public void helper(List<List<Integer>> res, List<Integer> list, int[] nums){
        if(list.size() == nums.length){
            /* 一定要new一个 否则会被后来remove清除 */
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(list.contains(nums[i])){
                continue;
            }
            list.add(nums[i]);
            helper(res, list, nums);
            /* 返回上一个循环前要清除掉之前的 */
            list.remove(list.size() - 1);
        }
    }
}