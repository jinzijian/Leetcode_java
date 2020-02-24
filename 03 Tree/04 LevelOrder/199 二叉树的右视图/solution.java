class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Queue <TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                if(i == 0){
                    res.add(cur.val);
                }
                if(cur.right != null) queue.offer(cur.right); 
                if(cur.left != null)  queue.offer(cur.left);
            }
        }
        return res;
    }
}