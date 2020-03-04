class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return new TreeNode(head.val);
        ListNode l = findMiddle(head);
        ListNode mid = l.next;
        ListNode r = l.next.next;
        TreeNode root = new TreeNode(mid.val);
        l.next = null;
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(r);
        return root;
    }
    public ListNode findMiddle(ListNode head){
        ListNode pre = new ListNode(0);
        pre = head;
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while(fast != null && fast.next != null){
            pre = pre.next;
            slow = slow.next;
            fast = fast.next.next;
        }
        return pre;
    }
}