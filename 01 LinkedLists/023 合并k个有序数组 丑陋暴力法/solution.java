/**丑陋解法*/
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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = new ListNode(-1000000000);
        /**丑陋解法，为了让res永远在第一个强行给赋值一个特别小的值*/
        for(int i = 0; i< lists.length;i++){
            res = mergeTwoLists(lists[i],res);
        }
        return res.next;
    }
}