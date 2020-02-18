class Solution {
    public ListNode mergetwoLists(ListNode l1,ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode res = dummy;
        while(l1!= null || l2 != null){
            if(l1 != null && l2==null){
                dummy.next = new ListNode(l1.val);
                l1 = l1.next;
                dummy = dummy.next;
            }
            if(l2 != null && l1==null){
                dummy.next = new ListNode(l2.val);
                l2 = l2.next;
                dummy = dummy.next;
            }
            if(l1 != null && l2 !=null && l1.val<= l2.val){
                dummy.next = new ListNode(l1.val);
                l1 = l1.next;
                dummy = dummy.next;
            }
            if(l1 != null && l2 !=null && l1.val > l2.val){
                dummy.next = new ListNode(l2.val);
                l2 = l2.next;
                dummy = dummy.next;
            }
        }
        return res.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        ListNode res = lists[0];
        int i = 1;
        while(i<lists.length){
            res  = mergetwoLists(res,lists[i]);
            i+=1;
        }
        return res;
    }
}