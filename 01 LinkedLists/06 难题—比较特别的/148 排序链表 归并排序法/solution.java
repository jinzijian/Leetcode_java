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
    /**归并排序*/
    /**step1:找中点*/
    /**step2:左右两边分别排序（递归）*/
    /**step2:融合两个有序链表*/
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        /**找中点*/
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!= null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode cur = slow.next;
        slow.next = null;
        ListNode left =sortList(head);
        ListNode right = sortList(cur);
        return mergeTwoLists(left,right);
    }
}