/**思路：找到最后一个不为9的节点，将其加一，将其之后的都变为零*/
class Solution {
    public ListNode plusOne(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = head;
        ListNode t = dummy;
        while(p!= null){
            if (p.val != 9){
                t = p;
                p = p.next;
            }
            else{
                p = p.next;
            }
        }
        t.val +=1 ;
        p = t.next;
        while(p!=null){
            p.val = 0;
            p = p.next;
        }
        if(t == dummy){
            return dummy;
        }else{
            return dummy.next;
        }
    }
}