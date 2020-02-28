class Solution {
    List<Integer> res = new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        helper(root);
        for(int i = 1; i < res.size(); i++){
            int j = i - 1;
            if(res.get(i) <= res.get(j)){
                return false;
            }
        }
        return true;
    }
    private void helper(TreeNode root){
        if(root == null) return;
        helper(root.left);
        res.add(root.val);
        helper(root.right);
    }
}