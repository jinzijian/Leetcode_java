class Solution {
    List<String> res = new ArrayList<>();
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        helper(root, "");
        return addSolution(res);
    }
    private void helper(TreeNode root, String list){
        if(root == null) return;
        if(root.left == null && root.right == null){
            list += root.val;
            res.add(list);
        }else{
            helper(root.left, list+root.val);
            helper(root.right, list+root.val);
        }
    }
    private int addSolution(List<String> res){
        int result = 0;
        for(int i = 0; i < res.size(); i++){
            result += Integer.parseInt(res.get(i));
        }
        return result;
    }
}