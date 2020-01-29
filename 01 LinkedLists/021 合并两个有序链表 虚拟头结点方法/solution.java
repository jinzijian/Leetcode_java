/**这题没啥就是细心考虑所有情况就完事了*/
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyhead = new ListNode(0);
        ListNode cur = dummyhead;
        while(l1!=null || l2!=null){
            if(l1 == null && l2!=null){
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
            if (l1!= null && l2 == null){
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            }
            if(l1!=null && l2!= null){
                if (l1.val>=l2.val){
                    cur.next = l2;
                    l2 = l2.next;
                    cur = cur.next;
                }else{
                    cur.next = l1;
                    l1 = l1.next;
                    cur = cur.next;
                }
            }

        }
        return dummyhead.next;
    }
}