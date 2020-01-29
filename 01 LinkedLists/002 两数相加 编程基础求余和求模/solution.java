/**
 *数学法：核心是取余数和求模
 *需要注意细节：最后sum还剩1 要记得加上
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);/**创建哑结点*/
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode cur = dummy;
        int sum = 0;
        while(p1!= null || p2!= null){
            if (p1!=null){
                sum += p1.val;
                p1 = p1.next;
            }
            if (p2!=null){
                sum += p2.val;
                p2 = p2.next;
            }
            cur.next = new ListNode(sum%10);/**求模*/
            sum = sum/10;/**求余数，下一次循环使用*/
            cur = cur.next;
        }
        if (sum == 1){
            cur.next = new ListNode(1);
        }
        return dummy.next;
    }
}