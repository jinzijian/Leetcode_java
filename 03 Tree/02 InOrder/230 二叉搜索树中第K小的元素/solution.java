class Solution {
    //注意count要是全局变量，因为作为置传入进去则是递归层数而不是第k个
    int res;
    int count;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        res = 0;
        helper(root);
        return res;
    }
    public void helper(TreeNode root){
        if(root == null) return;
        helper(root.left);
        count--;
        if(count == 0) res = root.val;
        helper(root.right);
    }
}