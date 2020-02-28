class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        helper(root);
        return res;
    }
    public void helper(TreeNode root){
        if(root == null) return;
        res.add(root.val);
        helper(root.left);
        helper(root.right);
    }
}