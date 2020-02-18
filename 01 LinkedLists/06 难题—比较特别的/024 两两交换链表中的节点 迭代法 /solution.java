/*迭代法*/
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = new ListNode(0);
        ListNode res = head.next;
        pre.next = head;
        ListNode first = head;
        ListNode second = head.next;
        ListNode tmp = null;
        while(second!=null){
            tmp = second.next;
            pre.next = second;
            second.next = first;
            first.next = tmp;
            tmp = second;
            second = first;
            first = tmp;
            /*注意判断链表是否为空，为空则不进行下一次指针移动，直接break*/
            if(second.next == null) break;
            second = second.next.next;
            first = first.next.next;
            pre = pre.next.next;
        }
        return res;
    }
}