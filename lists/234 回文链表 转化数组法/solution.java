/**方法1：使用数组然后双指针法*/
class Solution {
    public boolean isPalindrome(ListNode head) {
            ListNode cur = head;
            List<Integer> vals = new ArrayList<>();
            while(cur!= null){
                vals.add(cur.val);
                cur = cur.next;
            }
            int i=0;
            int j = vals.size()-1;
            while(i<j){
                /**注意只能使用！.equals()因为是integer类型*/
                if (!vals.get(i).equals(vals.get(j))){
                    return false;
                }else{
                    i++;
                    j--;
                }
            }
            return true;
    }
}