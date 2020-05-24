class Solution {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder res = new StringBuilder();
        for(int i = S.length() - 1; i >= 0; i--) {
            if(S.charAt(i) == '-') continue;
            res.insert(0, S.charAt(i));
        }
        for(int i = res.length() - K; i > 0; i -= K) {
            res.insert(i, '-');
        }
        //保留大写toUpperCase()
        return res.toString().toUpperCase();
    }
}