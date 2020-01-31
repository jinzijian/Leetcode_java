/**插入排序：思路创建一个新链表代表有序区，原来链表代表无序区*/
 /**创建哑结点和指针p，每次比对p.next和无序区的值,将其插入到有序区*/
class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode cur = head;
        ListNode next = head;
        while(cur!=null){
            next = cur.next;
            ListNode p = dummy;
            while(p.next!=null && cur.val>=p.next.val){
                p = p.next;
            }
            next = cur.next;
            cur.next = p.next;
            p.next = cur;
            cur = next;
        }
        return dummy.next;
    }
}