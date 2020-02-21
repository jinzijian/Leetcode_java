//暴力回溯法，会超时
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        helper(res, s, "", wordDict, 0);
        return res;
    }
    private void helper(List<String> res ,String s, String ret, List<String> wordDict, int index) {
        if(index > s.length()) return;
        if(index == s.length()){
            res.add(ret);
            return;
        }
        for(int i = 1; i < s.length()+1; i++){
            if((index+i) > s.length() ) break;
            String tmp = s.substring(index,index+i);
            if(!wordDict.contains(tmp)) continue;
            helper(res, s, ret+tmp+(index+i == s.length()?"":" "), wordDict, index+i);
        }
    }
}