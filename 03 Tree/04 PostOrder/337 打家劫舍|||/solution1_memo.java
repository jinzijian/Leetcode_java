//本质山是一层层求最优
 //添加了记忆化搜索，二叉树一般用hashmap去存储
class Solution {
    public int rob(TreeNode root) {
        HashMap<TreeNode, Integer> memo = new HashMap<>();
        return helper(root, memo);
    }
    //为什么一定要单独开辟个辅助函数呢？避免每次递归把hashmap置空
    private int helper(TreeNode root, HashMap<TreeNode, Integer> memo){   
        if(root == null) return 0;
        if(memo.containsKey(root)) return memo.get(root);
        int money = root.val;
        if(root.left != null){
            money += helper(root.left.left, memo) + helper(root.left.right, memo);
        }
        if(root.right != null){
            money += helper(root.right.left, memo) + helper(root.right.right, memo);
        }
        int result =  Math.max(money, helper(root.left, memo) + helper(root.right, memo));
        memo.put(root, result);
        return result;
    }
}