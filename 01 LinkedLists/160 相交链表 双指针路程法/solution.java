/**路程法：链表a尾部和链表B相连，链表B尾部和链表A相连，这样两个链表总路程一致，第二次走到共同节点的时间一致，当两个链表都走到null时结束，说明无相交节点*/
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        /* 边界条件 */
        if(headB == null || headA == null) return null;
        ListNode l1 = headA;
        ListNode l2 = headB;
        while(l1!=l2){
            l1 = l1.next;
            l2 = l2.next;
            /*判断无交点时 是否走到了终点 */
            if(l1 == null && l2==null) return null;
            /*不能连接，只能重新放置指针*/
            if(l1 == null) l1 = headB;
            if(l2 == null) l2 = headA;
        }
        return l1;
    }
}