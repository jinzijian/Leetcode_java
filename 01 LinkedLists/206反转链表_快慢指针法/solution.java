class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        ListNode tmp = null;
        while(cur!=null){
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
        
    }
}