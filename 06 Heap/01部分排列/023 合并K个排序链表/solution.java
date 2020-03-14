class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        //修改comparetor
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (a, b) -> (a.val - b.val));
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for(ListNode list:lists){
            if(list != null) queue.add(list);
        }
        while(!queue.isEmpty()){
            cur.next = queue.poll();
            cur = cur.next;
            if(cur.next != null){
                queue.add(cur.next);
            }
        }
        return dummy.next;
    }
}