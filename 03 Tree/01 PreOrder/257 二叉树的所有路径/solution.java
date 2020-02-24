// preorder和回溯法是一样的，只不过二叉树有特有的层级关系每层最多只有两个值替代了for循环
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root == null) return res;
        helper(res, "", root);
        return res;
    }
    public void helper(List<String> res, String path, TreeNode root){
        if(root.left == null && root.right == null){
            res.add(path + root.val);
        }
        //因为string 所以可以直接做参数传入不用重置
        if(root.left != null) helper(res, path + root.val + "->" , root.left);
        if(root.right != null) helper(res, path + root.val + "->", root.right);
    }
}