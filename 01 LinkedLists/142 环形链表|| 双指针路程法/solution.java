/**双指针路程法，如无环直接返回null,如有环第一次相遇后，将fast置位于head*/
 /**slow，fast第二次相遇的焦点就是入环点*/
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null || head.next.next == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(slow != null && fast != null && fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                break;
            }
        }
        if (slow == fast){
            fast = head;
            while(slow!= fast){
                slow = slow.next;
                fast = fast.next;
            }
        return fast;
        }else{
            return null;
        }
    }
}