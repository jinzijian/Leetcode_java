/** 
 *解法二：递归法
 *把除首节点外其余反转然后把首节点反转
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode newlist = reverseList(head.next);
        head.next.next = head; /**把之前连接反向*/
        head.next = null;/**把之后变为null=[-*/
        return newlist;
    }
}