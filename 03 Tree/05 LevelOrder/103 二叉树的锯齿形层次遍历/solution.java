class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode cur = root;
        int count = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i++){
                cur = queue.poll();
                if(cur.right != null) queue.offer(cur.right);
                if(cur.left != null) queue.offer(cur.left);
                list.add(cur.val);
            }
            count++;
            if(count % 2 == 1){
                List<Integer> tmp = new ArrayList<>();
                for(int i = list.size()-1; i >= 0; i--){
                    tmp.add(list.get(i));
                }
                res.add(tmp);
            }else{
                res.add(list);
            }
        }
        return res;
    }
}