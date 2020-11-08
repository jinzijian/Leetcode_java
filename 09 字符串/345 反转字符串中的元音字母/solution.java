//双指针方法
class Solution {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        int l = 0;
        int r = len - 1;
        while(l < r) {
            while(!isValid(arr[l]) && l < r) l++;
            while(!isValid(arr[r]) && r > l) r--;
            char tmp = arr[r];
            arr[r] = arr[l];
            arr[l] = tmp;
            l++;
            r--; 
        }
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < arr.length; i++) {
            res.append(arr[i]);
        }
        return res.toString();


    }
    private boolean isValid(char t) {
        if(t == 'a' || t == 'e' || t == 'i' || t == 'o' || t == 'u' || t == 'A' || t == 'E' || t == 'I' || t == 'O' || t == 'U'){
            return true;
        }
        return false;
    } 
}