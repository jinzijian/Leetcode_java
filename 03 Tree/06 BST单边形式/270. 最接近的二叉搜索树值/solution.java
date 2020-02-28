//注意事项，子树内部有可能存在比子树根节点更合适的值，要记得吧返回的结果和根节点比较
class Solution {
    public int closestValue(TreeNode root, double target) {
        if(target > root.val && root.right != null ){
            return (Math.abs(root.val - target) < Math.abs(closestValue(root.right, target)- target)? root.val:closestValue(root.right, target));
        }else if(target < root.val && root.left != null){
            return (Math.abs(root.val - target) < Math.abs(closestValue(root.left, target)- target)? root.val:closestValue(root.left, target));
        }else{
            return root.val;
        }
    }
}