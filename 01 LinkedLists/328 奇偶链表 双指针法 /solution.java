/**
 双指针法
 思路：符合直觉的想法是，先遍历一遍找出奇数的节点。然后再遍历一遍找出偶数节点，最后串起来。但是有两个问题，如果不修改节点的话，需要借助额外的空间，空间复杂度是 N。如果修改的话，会对第二次遍历（遍历偶数节点）造成影响。
因此可以采用一种做法： 遍历一次，每一步同时修改两个节点就好了，这样就可以规避上面两个问题。 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null){
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenhead = even;
/**终止条件：因为链表长度有奇有偶，所以两种情况均需要考虑*/
        while(even!=null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even  = even.next;
            /**顺序很重要，先处理在前面的节点在处理后方的*/
        }
        odd.next = evenhead;
        return head;
    }
}