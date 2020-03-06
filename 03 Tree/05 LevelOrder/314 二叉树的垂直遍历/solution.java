//本质上值操作问题
 //用两个栈一个用来bfs一个用来记录index
 //前序遍历查出列的数量用于提前初始化res
class Solution {
    int min = 0;
    int max = 0;
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        helper(root, 0);
        for(int i = min; i <= max; i++){
            res.add(new ArrayList<>());
        }
        Queue<Integer> idx = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        idx.offer(-min);
        //小技巧，用来转化
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            int index = idx.poll();
            res.get(index).add(cur.val);
            if(cur.left != null){
                queue.offer(cur.left);
                idx.offer(index - 1);
            }
            if(cur.right != null){
                queue.offer(cur.right);
                idx.offer(index + 1);
            }
        }
        return res;
    }
    public void helper(TreeNode root, int index){
        if(root == null) return;
        min = Math.min(min, index);
        max = Math.max(max, index);
        helper(root.left, index - 1);
        helper(root.right, index + 1);
    }
}