//回溯法2：不记录路径，只记录个数，因为不记录中间状态只记录结果所以不用remove操作
//注意事项：int类型res 为值传递，需使用全局变量
//运行结果：不爆栈但是超时
class Solution {
    private int res = 0;
    public int combinationSum4(int[] nums, int target) {
        if(nums == null || nums.length == 0) return 0;
        helper(nums,target);
        return res;
    }
    public void helper(int[] nums, int target){
        if(target == 0){
            res += 1;
            return;
        }
        if(target < 0) return;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > target) continue;
            helper(nums, target - nums[i]);
        }
    }
}