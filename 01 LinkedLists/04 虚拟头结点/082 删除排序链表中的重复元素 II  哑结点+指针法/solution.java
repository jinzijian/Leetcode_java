/**哑结点+指针法*/
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null || head.next ==null) return head;
        /**因为可能首节点被删除所以创建哑结点*/
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        ListNode tmp = null;
        while(cur.next!= null && cur.next.next!=null){
            if (cur.next.val == cur.next.next.val){
                /**tmp指向第一个重复元素*/
                tmp = cur.next;
                /**利用循环更新tmp，结束后tmp指向最后一个重复元素*/
                while(tmp!=null && tmp.next!= null && tmp.val == tmp.next.val ){
                    tmp = tmp.next;
                }
                cur.next = tmp.next;
            }else{
                cur = cur.next;
            }

        }
        return dummy.next;
    }
}