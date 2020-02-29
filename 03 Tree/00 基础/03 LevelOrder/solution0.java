//queue队列实现
 //先进先出，后进后出
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode cur = root;
        //当queue为空遍历即结束，因为不涉及cur的变化 
        //且永远是先加入，后提取，所以永远cur不会为空
        while(!queue.isEmpty()){
            int size = queue.size();
            //一定要提前把当前层的queuesize存下
            List<Integer> list = new ArrayList<>();
            //这个循环相当于只遍历当前层
            for(int i = 0; i < size; i++){
                cur = queue.poll();
                if(cur.left != null) queue.offer(cur.left);
                if(cur.right != null) queue.offer(cur.right);
                list.add(cur.val);
            }
            res.add(list);
        }
        return res;
    }
}