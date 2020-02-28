class Solution {
    int count = 1;
    int max = 0;
    Integer pre = null;
    public int[] findMode(TreeNode root) {
        if(root == null) return new int[0];
        //list不一定作为参数传入，全局变量也可以，但参数更合适
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        //list转数组
        int[] result = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            result[i] = list.get(i);
        }
        return result;

    }
    private void helper(TreeNode root, List<Integer> list){
        if(root == null) return;
        helper(root.left, list);
        //pre == null 即首个直接跳过了
        if(pre != null){
            if(pre == root.val){
                count += 1;
            }else{
                count = 1;
            }
        }
        if(count > max){
            max = count;
            list.clear();
            list.add(root.val);
        }else if(count == max){
            list.add(root.val);
        }
        //更新count max方法值得学习
        pre = root.val;
        helper(root.right, list);
    }
}