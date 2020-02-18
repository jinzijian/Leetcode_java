/**迭代法*/
 /**先部分反转再重新连接*/
class Solution {
    public ListNode reverse(ListNode head){
        if (head == null && head.next == null) return head;
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        dummy.next = head;
        ListNode slow = head;
        ListNode fast = head;
        int i = 1;
        while(i<m){
            pre = pre.next;
            slow = slow.next;
            i+=1;
        }
        int j = 1;
        while(j<n){
            fast = fast.next;
            j += 1;
        }
        ListNode tmp = fast.next;
        fast.next = null;
        ListNode rev  = reverse(slow);
        slow.next = tmp;
        pre.next = rev;
        return dummy.next;
    }
}