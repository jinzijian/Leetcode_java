class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head == null){
            return head;
        }
        ListNode greater = new ListNode(0);
        ListNode smaller = new ListNode(0);
        ListNode l1 = smaller;
        ListNode l2 = greater;
        ListNode p = head;
        while(p!=null){
            if (p.val < x){
                smaller.next = p;
                smaller = smaller.next;
                p = p.next;
            }else{
                greater.next = p;
                greater = greater.next;
                p = p.next;
            }
        }
        smaller.next = l2.next;
        greater.next = null;/**别忘了给最后置空*/
        return l1.next;

    }
}