class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        if(n<=1 ) return res;
        helper(res, new ArrayList<>(), n,2);
        return res;
    }
    
    public void helper(List<List<Integer>> res, List<Integer> list, int n, int start){
        if(n == 1){
            if(list.size()>1){
                res.add(new ArrayList<>(list));
            }
        }
        for(int i = start; i<=n; i++){
            if(n % i == 0){
                list.add(i);
                helper(res,list,n/i,i);
                list.remove(list.size()-1);
            }
        }
    }
}
    