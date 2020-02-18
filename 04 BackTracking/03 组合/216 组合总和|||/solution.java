class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (n == 0 || k == 0) return res;
        helper(res, new ArrayList<>(), k, n,  1);
        return res;
    }
    public void helper(List<List<Integer>> res, List<Integer> list, int k, int n, int start){
        if(k == 0 && n == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        if(k == 0 && n!= 0){
            return;
        }
        for(int i = start; i < 10; i++){
            list.add(i);
            helper(res, list, k-1, n-i, i+1);
            list.remove(list.size()-1);
        }
    }
}