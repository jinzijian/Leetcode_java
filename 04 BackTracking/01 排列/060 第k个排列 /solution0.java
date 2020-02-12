/*暴力回溯 会超出时间限制*/
class Solution {
    public  String getPermutation(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if(n == 0 || k == 0) return "";
        int[] nums;
        nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        helper(res, new ArrayList<>(), nums);
        int m = 0;
        List<Integer> x = new ArrayList<>(n);
        /*list要用get方法*/
        x = res.get(k-1);
        for(int i = 0; i < n; i++){
            m += x.get(i)*Math.pow(10,n-1-i);
        }
        String result = m + "";
        return result;
    }
    public void helper(List<List<Integer>> res, List<Integer> list, int[] nums) {
        if(list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(list.contains(nums[i])) continue;
            list.add(nums[i]);
            /*注意都在循环内部*/
            helper(res, list, nums);
            list.remove(list.size()-1);
        }
    }
}