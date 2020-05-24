class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0) return 0;
        if(haystack.length() < needle.length()) return -1;
        int i = 0;
        int j = needle.length();
        while(i + j <= haystack.length()) {
            String cur = haystack.substring(i , i + j);
            if(cur.equals(needle)) return i;
            i = i + 1;
        }
        return -1;
    }
}