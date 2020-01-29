/** 快慢指针法：先用快慢指针找到中点，再将后半部分反转进行比较*/
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }
        /** 找中点 */
        ListNode p = new ListNode(-1);
        /** 找中点重点是要有虚拟节点，这样可以避免奇偶数的问题 */
        ListNode slow = p;
        ListNode fast = p;
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
        /** 前半段与反转后的后半段比较 */
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