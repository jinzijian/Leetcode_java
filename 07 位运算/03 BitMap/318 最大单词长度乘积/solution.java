// bitmap
class Solution {
    public int maxProduct(String[] words) {
        int res = 0;
        int[] bytes = new int[words.length];
        for(int i = 0; i < words.length; i++){
            int val = 0;
            for(int j = 0; j < words[i].length(); j++){
                val |= 1 << (words[i].charAt(j) - 'a');
            }
            bytes[i] = val;
        }
        for(int i = 0; i < bytes.length; i++){
            for(int j = 1; j < bytes.length; j++){
                if((bytes[i] & bytes[j]) == 0){
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }
}