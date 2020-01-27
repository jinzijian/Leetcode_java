/**递归法：先反转前n个，在进行递归*/
class Solution {
    /**定义一个方法能反转链表的前n个值*/
    ListNode successor = null; 
    ListNode last = null;
    /**这个变量不能写在方法里不然每次都被置空 */
    public ListNode reverseN(ListNode head,int n){
        /**终止条件，不反转的情况*/
        if (n==1){
            successor = head.next;
            return head;
             /**head节点反转后不一定是尾节点，所以要记录后驱*/
            
        }
        last = reverseN(head.next,n-1);
        head.next.next = head;/**把新的连接到首节点*/
        head.next = successor;/**把首节点与第n+1个节点连接*/
        return last;
    }
    public ListNode reverseBetween(ListNode head, int m, int n) {
        /**采用递归方法*/
        if(m==1){
            return reverseN(head,n);
        }
        // 前进到反转的起点触发 base case
        head.next = reverseBetween(head.next,m-1,n-1);
        return head;
        
    }
}