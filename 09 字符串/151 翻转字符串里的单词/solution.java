class Solution {
    public String reverseWords(String s) {
        s = s.trim();//去除首尾空格
        int j = s.length()-1;
        int i = j;
        StringBuilder res = new StringBuilder();
        while(i >= 0){
            while(i >= 0 && s.charAt(i) != ' ') i--;
            res.append(s.substring(i + 1, j + 1) + ' ');
            while(i >= 0 && s.charAt(i) == ' ') i--;
            j = i;
        }
        return res.toString().trim();
    }
}