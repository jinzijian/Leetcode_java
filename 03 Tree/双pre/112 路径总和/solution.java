class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        //边界条件
        if(root == null) return false;
        //终止条件
        if(root.left == null && root.right == null){
            return sum == root.val;
        }
        //核心代码，本质上不是遍历问题而是单纯走到底
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}