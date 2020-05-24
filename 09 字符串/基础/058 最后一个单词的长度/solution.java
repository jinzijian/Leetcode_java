class Solution {
    public int lengthOfLastWord(String s) {
        String[] res = s.split("\\s+");
        if(res.length == 0) return 0;
        String tmp = res[res.length - 1];
        return tmp.length();
    }
}