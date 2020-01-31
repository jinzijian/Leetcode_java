/**快慢指针法:可以无视奇偶，但记得是指向奇数中点和偶数靠右侧的中点。*/
 /**若链表长度为偶数时需要靠左的中点则 终止条件为：fast.next!=null && fast.next.next!= null*/
class Solution {
    public ListNode middleNode(ListNode head) {
        if(head.next==null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}