//和100题类似只是左右互换
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return helper(root.right, root.left);
    }
    private boolean helper(TreeNode p, TreeNode q){
        if(p == null && q == null) return true;
        if(p!= null && q!= null && p.val == q.val){
            return helper(p.left, q.right) && helper(p.right, q.left);
        }else{
            return false;
        }
    }
}