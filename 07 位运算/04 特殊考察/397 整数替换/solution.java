class Solution {
    public int integerReplacement(int n) {
        long N = n;
        int res = 0;
        while(N != 1){
            if(N % 2 == 0){
                N = N / 2;
                res++;
            }else{
                if(N == 3){
                    res += 2;
                    break;
                }
                N = (N & 2) == 2 ? N+1 : N-1;
                res++;
            }
        }
        return res;
    }
}