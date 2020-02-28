//遍历中序遍历
 //两个逆序对，第一个和末尾交换
 //一个逆序对 直接交换
class Solution {
    public void recoverTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<TreeNode> res = new ArrayList<>();
        TreeNode cur = root;
        TreeNode pre = null;
        int tmp = 0;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if(pre != null && pre.val > cur.val){
                res.add(pre);
                res.add(cur);
            }
            pre = cur;
            cur = cur.right;
        }
        if(res.size() == 4){
            TreeNode node1 = res.get(0); 
            TreeNode node2 = res.get(3);
            tmp = node1.val;
            node1.val = node2.val;
            node2.val = tmp;
        }
        if(res.size() == 2){
            TreeNode node1 = res.get(0); 
            TreeNode node2 = res.get(1);
            tmp = node1.val;
            node1.val = node2.val;
            node2.val = tmp;
        }
        return;
    }
}