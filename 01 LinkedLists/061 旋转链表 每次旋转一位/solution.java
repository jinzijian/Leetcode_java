/**每次旋转一位*/
/**要提前算好size不然每次计算会导致超时*/
class Solution {
    public int findsize(ListNode head){
        ListNode tmp = head;
        int size = 0;
        while(tmp!= null){
            tmp = tmp.next;
            size+=1;
        }
        return size;
    }
    public ListNode rotateone(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode f = head.next;
        ListNode s = head;
        while(f.next!=null){
            f = f.next;
            s = s.next;
        }
        s.next = null;
        f.next = head;
        return f;

    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        int size = findsize(head);
        k = k%size;
        while(k>0){
            head = rotateone(head);
            k -= 1;
        }
        return head;
    }
}