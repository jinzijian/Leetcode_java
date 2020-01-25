/**迭代法*/
 /**先部分反转再重新连接*/
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode tmp = null;
        ListNode top = null;/**用来记录m前的一个节点*/
        ListNode tail = null;/**用来记录m节点*/
        ListNode pre = null;
        ListNode cur = head;
        /**这里m>1下面n>0 是因为cur要越过n*/
        while(m>1){
            m--;
            n--;
            pre = cur;
            cur = cur.next;
        }
        top = pre;
        tail = cur;
        /**反转链表结束 cur指向n的后一个*/
        while(n>0){
            n--;
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
            /**cur在这里指向n后面的一个节点*/
        }
        /**要判断top是否存在避免从第一个节点开始反转的情况*/
        if (top!=null){
            top.next = pre;
        }else{
            head = pre;
        }
        tail.next = cur;
        /**重新连接起来*/
        return head;
    }
}