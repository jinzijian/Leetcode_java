class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur!= null || !stack.isEmpty()){
            //while语句的意思相当于 stack为空 所指的cur也为空时 全部遍历完毕
            //与前序不同，前序cur节点永远在stack最上方，中序遍历要先看左节点，所以stack在遍历过程中也可能为空
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            } 
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;

    }
}