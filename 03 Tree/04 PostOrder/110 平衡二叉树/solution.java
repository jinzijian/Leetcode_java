//递归使用
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if(isBalanced(root.left) && isBalanced(root.right) && Math.abs(left - right) <= 1){
            return true;
        }else{
            return false;
        }
    }
    private int maxDepth(TreeNode root){
        if(root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}