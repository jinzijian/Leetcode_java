// 暴力回溯优化版 勉强ac
class Solution {
    private StringBuilder string = new StringBuilder();
    private int count = 0;
    public  String getPermutation(int n, int k) {
        if(n == 0 || k == 0) return "";
        helper(n, k, new boolean[n+1]);
        String result = string.toString();
        return result;
    }
    public void helper(int n, int k, boolean[] used) {
        if(string.length()== n){
            count += 1;
            return;
        }
        for(int i = 1; i < n+1; i++) {
            if(used[i]) continue;
            string.append(String.valueOf(i));
            used[i] = true;
            helper(n,k,used);
            if (count == k) return;
            used[i] = false;
            string.deleteCharAt(string.length()-1);
        }
    }
}