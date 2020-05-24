class Solution {
    public int countSegments(String s) {
        String[] arr = s.split("\\s+");
        int res = 0;
        for(String t : arr) {
            if(t.isEmpty()) continue;
            res++;
        }
        return res;
    }
}