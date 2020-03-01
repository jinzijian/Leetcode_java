class Solution {
    int count = 0;
    public int countUnivalSubtrees(TreeNode root) {
        helper(root);
        return count;

    }
    public boolean helper(TreeNode root){
        if(root == null) return true;
        boolean sign = true;
        //借助sign去表示数值是否相等，从而规避复杂性
        if(root.left != null){
            sign = sign && (root.val == root.left.val);
        }
        if(root.right != null){
            sign = sign && (root.val == root.right.val);
        }
        //用&而不是&&是为了判断同时执行该语句
        if(helper(root.left) & helper(root.right) & sign){
            count += 1;
            return true;
        }
        return false;
    }
}