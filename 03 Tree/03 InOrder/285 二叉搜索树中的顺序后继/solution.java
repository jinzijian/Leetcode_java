class Solution {
    List<TreeNode> res = new ArrayList<>();
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        helper(root);
        int tmp = 0;
        for(int i = 0; i < res.size(); i++){
            if(res.get(i) == p){
                tmp = i + 1;
                break;
            }
        }
        if(tmp >= res.size()) return null;
        return res.get(tmp);
    }
    public void helper(TreeNode root){
        if(root == null) return;
        helper(root.left);
        res.add(root);
        helper(root.right);
    }
}