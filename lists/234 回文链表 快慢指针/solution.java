/** 快慢指针法：先用快慢指针找到中点，再将后半部分反转进行比较*/
public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }
        /** 找中点 */
        ListNode p = new ListNode(-1);
        ListNode fast = p;
        ListNode slow = p;
        p.next = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode pre = null;
        ListNode cur = slow.next;
        ListNode tmp = null;
        slow.next = null;
        slow = p.next;
        while(cur!=null){
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        while(pre!=null){
            if (pre.val != slow.val ){
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }
        return true;
        
    }
}