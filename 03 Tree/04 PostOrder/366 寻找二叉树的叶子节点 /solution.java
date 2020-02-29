//经验：分组，想到借助一个level变量来进行辅助
class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, res);
        return res; 
    }
    private int helper(TreeNode root, List<List<Integer>> res){
        if( root == null) return -1;
        int left = helper(root.left, res);
        int right = helper(root.right, res);
        //因为递归所有操作相互独立
        int level = Math.max(left, right) + 1;
        //和求最大深度类似
        //level还用来开辟和控制res里list的创建添加
        if(res.size() == level){
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        //删除
        root.left = null;
        root.right = null;
        return level;
    }
}