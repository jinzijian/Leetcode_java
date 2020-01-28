/** 快慢指针法 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head==null || head.next==null || head.next.next== null){
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(slow!=null && fast!=null && fast.next!=null ){
            slow = slow.next;
            fast = fast.next.next;
            /** null无法调用.next方法，所以必须判断fast.next!= null */
            if (slow == fast){
                return true;
            }
        }
        return false;
        
    }
}