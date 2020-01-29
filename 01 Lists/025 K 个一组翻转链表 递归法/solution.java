/** 递归法 */
 /** 问题拆解：反转前k个在把后面的连起来 */
 /** 反转前k个 */
class Solution {
    public ListNode reverseab(ListNode a, ListNode b) {
        /** 注意这里是反转[a,b)左闭右开 */
        ListNode pre = null;
        ListNode cur = a;
        ListNode tmp = null;
        while (cur!=b){
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
    /** 反转后连接 */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head==null){
            return null;
        }
        ListNode a = head;
        ListNode b = head;
        for(int i=0;i<k;i++){
            if (b==null){
                 /** 判断剩余节点是否不足k个 */
                return head;
            }else{
                b = b.next;
            }
        }
        ListNode newHead = reverseab(a, b);
        a.next = reverseKGroup(b,k);
        return newHead;
    }
}