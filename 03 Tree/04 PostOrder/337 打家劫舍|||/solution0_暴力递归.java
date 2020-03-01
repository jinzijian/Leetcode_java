//本质山是一层层求最优
class Solution {
    public int rob(TreeNode root) {
        if(root == null) return 0;
        int money = root.val;
        if(root.left != null){
            money += rob(root.left.left) + rob(root.left.right);
        }
        if(root.right != null){
            money += rob(root.right.left) + rob(root.right.right);
        }
        return Math.max(money, rob(root.left) + rob(root.right));
    }
}