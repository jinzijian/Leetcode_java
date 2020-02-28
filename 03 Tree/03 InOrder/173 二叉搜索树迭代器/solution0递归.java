//递归方法，先中序存入数组，在处理
class BSTIterator {
    List<Integer> res;
    int index;
    public BSTIterator(TreeNode root) {
        res = new ArrayList<>();
        index = -1;
        inorder(root);
    }
    public void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        res.add(root.val);
        inorder(root.right);
    }
    
    /** @return the next smallest number */
    public int next() {
        index = index+1;
        return res.get(index);
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return (index + 1 < res.size());
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */