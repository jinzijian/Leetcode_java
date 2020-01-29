/**删除链表中的节点，因为没给初始节点，所以只能从之后下手*/
 /**所以把后一个节点的值赋给要删除的节点然后把后一个节点删除*/
class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}