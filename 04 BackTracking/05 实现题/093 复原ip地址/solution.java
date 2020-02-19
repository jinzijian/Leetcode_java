class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        helper(res, s, 0, "", 0);
        return res;
    }
    
    public void helper(List<String> res, String s, int index, String ret, int count ){
        if(count > 4) return;
        if(count == 4 && index==s.length()){
            res.add(ret);
            return;
        }
        for (int i = 1; i < 4; i++){
            if(index+i > s.length()) break;
            String tmp = s.substring(index, index+i);
            if((tmp.startsWith("0") && tmp.length()>1) || (i == 3 && Integer.parseInt(tmp) >= 256)) continue;   
            helper(res, s, index+i, ret + tmp + (count == 3?"":"."), count+1);
        }
    }
}