class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        helper(root);
        return res;
    }
    private void helper(TreeNode root){
        if(root == null) return;
        helper(root.left);
        helper(root.right);
        res.add(root.val);
    }
}