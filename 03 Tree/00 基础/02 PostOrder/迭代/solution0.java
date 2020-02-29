//迭代法 https://blog.csdn.net/zhangxiangDavaid/article/details/37115355
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;
        while(cur != null){
            stack.push(cur);
            cur = cur.left;
        }
        while(!stack.isEmpty()){
            cur = stack.pop();
            if(cur.right == null || pre == cur.right){
                res.add(cur.val);
                pre = cur;
            }else{
                stack.push(cur);
                cur = cur.right;
                while(cur != null){
                    stack.push(cur);
                    cur = cur.left;
                }
            }
        }
        return res;
    }
}