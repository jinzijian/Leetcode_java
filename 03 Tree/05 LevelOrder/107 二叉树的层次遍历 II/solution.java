class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode cur = root;
        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for(int i = 0; i < size; i++){
                cur = queue.poll();
                if(cur.left != null) queue.offer(cur.left);
                if(cur.right!=null) queue.offer(cur.right);
                list.add(cur.val);
            }
            res.add(list);
        }
        List<List<Integer>> result = new ArrayList<>();
        for(int i = res.size()-1; i >= 0; i--){
            result.add(res.get(i));
        }
        return result;
    }
}