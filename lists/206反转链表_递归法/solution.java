/** 
 *解法一：快慢指针法（迭代法）
 *每一次把cur节点指向pre节点，然后前移更新pre和cur，所以要提前储存cur.next
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode tmp = null;/** 定义前后2个指针，和tmp这个变量*/
        while(cur!= null){
            tmp = cur.next;/** 存储cur.next的值，因为之后修改后会变动所以要先存储*/
            cur.next = pre;/** 把当前节点指向前一个节点*/
            pre = cur;
            cur = tmp;/** 两个指针同时后移*/
        }
        return pre;/** 因为返回pre才能遍历一遍，所以一开始是while（cur！= null）*/
    }
}