//思路解释
 //首先想到这个题求公共子节点自然而然想到自下而上遍历，所以可以初步判定采用后序
 //要使用递归方法，那么我们首先要思考递归函数的目的
 //本题要求返回的是节点值，那么返回类型必须是节点
 //我们再来看下有什么特性
 //（1）p，q分出左右两子树则中间节点即为公共祖先 
 //（2）若都在一颗子树内，则只需看这颗子树的根左右
 //（3）若pq分别存在root的左右子树，那么理论上该直接返回root，到最顶层
 // (4) 若一棵树单独含有p或者q，那么为了能让（3）成立我们需要将pq返回到上层
 // 那么现在来总结下函数功能
 // (1) root == p/q 返回 root（等同于返回p/q）
 //（2）root左右子树包含p/q， 返回p/q;
 // (3) root左右子树 分别包含p q， root就是最终答案需要一路返回到最上层
 //（4） 终止条件 root == null 返回null
 //
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root == p || root == q) return root;
        //先自底而上找到在哪个子树
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //因为自底而上一直在传递答案，所以答案直接返回就行了
        if(left == null) return right;
        if(right == null) return left;
        if(left != null && right != null) return root;
        return null;
        //里面隐含left和right都为null 返回null
    }
}