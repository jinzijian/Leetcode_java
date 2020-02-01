/*递归法*/
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        } 
        ListNode dummy = new ListNode(0);
        ListNode slow = head;
        ListNode fast = head.next;
        ListNode tmp = null;
        dummy.next = fast;
        tmp = fast.next;
        fast.next = slow;
        slow.next = swapPairs(tmp);
        return dummy.next;
    }
}