//因为是高度平衡所以每次选择中间节点作为根节点
 //奇数情况无需讨论
 //偶数情况选择靠左/右
 //本题代码中选择靠左
 // 二分法的题需要好好练下
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        return helper(nums, left, right);
    }
    private TreeNode helper(int[] nums, int l, int r){
        if(l > r) return null;
        int mid = l + (r-l)/2;
        //避免溢出
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, l, mid - 1);
        root.right = helper(nums, mid + 1, r);
        return root;
    }
}