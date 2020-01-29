/**递归法*/
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null){
            return null;
        }
        if (head.next == null){
            return head;
        }
        ListNode first = head;
        ListNode second = head.next;
        first.next = swapPairs(head.next.next);/**为啥这两条语句顺序不能颠倒*/
        second.next = first;/**为啥这两条语句顺序不能颠倒*/
        /**解答：若颠倒则first和second互为next死循环*/
        return second;
    }
}