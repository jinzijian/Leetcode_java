//借助前序特性发现第一个值是根节点
 //根据中序特性+已知的根节点的值知道左右子树及其长度
 //由于知道长度可以吧前序左右子树划分出来
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        int i = 0;
        while(preorder[0] != inorder[i]){
            i += 1;
        }
        //java Arrays.copyOfRange方法 左闭右开
        root.left = buildTree(Arrays.copyOfRange(preorder,1,i+1), Arrays.copyOfRange(inorder,0,i));
        root.right = buildTree(Arrays.copyOfRange(preorder,i+1,preorder.length), Arrays.copyOfRange(inorder,i+1,inorder.length));
        return root;
    }
}