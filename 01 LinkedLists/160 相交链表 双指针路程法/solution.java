/**路程法：链表a尾部和链表B相连，链表B尾部和链表A相连，这样两个链表总路程一致，第二次走到共同节点的时间一致，当两个链表都走到null时结束，说明无相交节点*/
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        if(headA==null || headB == null){
            return null;
        }
        while(p1!=p2){
            p1 = p1.next;
            p2 = p2.next;
            if (p1 == null && p2 == null){
                return null;
            }
            if (p1 == null){
                p1 = headB;
            }
            if (p2 == null){
                p2  = headA;
            }
        }
        return p1;
    }
}