//和回溯法本质相同
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        helper(res, new ArrayList<>(), root, sum);
        return res;
    }
    public void helper(List<List<Integer>> res, List<Integer> list, TreeNode root, int sum){
        if(root == null) return;
        list.add(root.val);
        if(root.left == null && root.right == null){
            if(root.val == sum){
                res.add(new ArrayList<>(list));
            }
        }
        helper(res, list, root.left, sum - root.val);
        helper(res, list, root.right, sum - root.val);
        list.remove(list.size()-1);
    }
}