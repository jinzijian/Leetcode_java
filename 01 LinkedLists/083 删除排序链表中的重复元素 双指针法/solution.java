/**双指针法*/
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null || head.next ==null) return head;
        ListNode cur = head.next;
        ListNode pre = head;
        while(cur!=null){
            if (cur.val == pre.val){
                /**需要注意的是：相等时只更新cur不更新pre*/
                pre.next = cur.next;
                cur = pre.next;
            }else{
                cur = cur.next;
                pre = pre.next;
            }
        }
        return head;
    }
}