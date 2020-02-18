/**思路：（1）寻找中心节点；（2）分为两部分，反转后半部分；（3）合并两个链表*/
class Solution {
    public ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        ListNode tmp = null;
        while(cur!= null){
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
    public ListNode findmid(ListNode head){
        if (head == null && head.next==null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null){
            return;
        }
        ListNode mid = findmid(head);
        ListNode l2 = reverse(mid.next);
        mid.next = null;
        ListNode l1 = head;
        ListNode tmp = null;
        while(l2!=null){
            tmp = l2.next;
            l2.next = l1.next;
            l1.next = l2;
            l1 = l2.next;
            l2 = tmp;
        }

    }
}