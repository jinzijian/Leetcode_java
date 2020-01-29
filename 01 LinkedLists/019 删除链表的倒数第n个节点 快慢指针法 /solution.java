/**快慢指针法*/
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(-1);
        ListNode slow = head;
        ListNode fast = head;
        pre.next = head;
        for(int i=1;i<n;i++){
            fast = fast.next;
        }
        /**注意判断只有一个值的特殊情况*/
        if (head.next==null && n==1){
            return null;
        }
        while(slow!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next;
            pre = pre.next;

        }
        /**注意判断需清除第一个节点的时候*/
        if(pre.val != -1 ){
            pre.next = slow.next;
            return head;
        }
        return head.next;
        
    }
}