/**头插法*/
 /**举例：1-2-3-4-5变为1-3-4-2-5*/
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
       ListNode cur = head;
       ListNode dummy = new ListNode(0);
       dummy.next = head;
       ListNode tmp = null; 
       ListNode pre = dummy;
       /**pre指向1，cur指向2*/
       while (m>1){
           m--;
           n--;
           pre = cur;
           cur = cur.next;
       }
      while(n>1){
          n--;
          tmp = cur.next;
          /**tmp记录3-4-5*/
          cur.next  = tmp.next;
          /**2-4-5，把3断开*/
          tmp.next = pre.next;
          /**把3-2连上变为3-2-4-5*/
          pre.next = tmp;  
          /**把1和3连上变为1-3-2-4-5*/
          /**现在cur还是指向2.pre还是指向1*/
      }
      return dummy.next;
    }
}