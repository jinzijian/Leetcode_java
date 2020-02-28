//巧妙做法O(n)时间复杂度
class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        LinkedList<Integer> res = new LinkedList<>();
        helper(root, target, k, res);
        return res;
    }
    private void helper(TreeNode root, double target, int k, LinkedList<Integer> res){
        if(root == null) return;
        helper(root.left, target, k, res);
        if(res.size() == k){
            int tmp = res.peekFirst();
            //因为递增数列，所以新加入的一定和第一个差距最大
            if(Math.abs(tmp - target) > (Math.abs(root.val - target))){
                res.removeFirst();
            }else{
                return;
                //之后的只会越来越不满足直接返回就是结果了
            }
        }
        res.add(root.val);
        helper(root.right, target, k, res);

    }
}