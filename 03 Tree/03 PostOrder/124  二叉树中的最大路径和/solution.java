//postorder类型
//从下向上遍历，利用子树的情况下使用postorder
class Solution {
    //值传递所以是类变量
    int res;
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        res = Integer.MIN_VALUE;
        helper(root);
        return res;
    }
    public int helper(TreeNode root){
        if(root == null) return 0;
        //有可能有负数所以要和零比较
        int left = Math.max(helper(root.left),0);
        int right = Math.max(helper(root.right),0);
        //注意 res和返回值不一样
        res = Math.max(left + right + root.val, res);
        return Math.max(left,right) + root.val;
    }
}