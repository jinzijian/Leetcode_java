//回溯+记忆化：本质上是分别固定一个值再求其（target-被固定值）的个数，最后累加
class Solution {
    public int combinationSum4(int[] nums, int target) {
        if(nums == null || nums.length == 0) return 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        return helper(nums, target, map);
    }

    private int helper(int[] nums, int target, HashMap<Integer, Integer> map) {
        // 需使用带返回值的格式是为了返回记忆化的结果
        if(target < 0) return 0;
        if(target == 0) return 1;
        if(map.containsKey(target)){
            return map.get(target);
        }
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            res += helper(nums, target - nums[i], map);
        }
        map.put(target, res);
        return res;
        //不要忘了返回res
    }
}