class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums1.length == 0 || nums2.length == 0 || k == 0) return res;
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> (a[0]+ a[1] - b[0] - b[1]));
        for(int i = 0; i < k && i < nums1.length; i++){
            q.offer(new int[]{nums1[i], nums2[0], 0});
        }
        while(!q.isEmpty() && k-- > 0){
            int[] cur = q.poll();
            List<Integer> tmp = new ArrayList<>();
            tmp.add(cur[0]);
            tmp.add(cur[1]);
            res.add(tmp);
            if(cur[2] == nums2.length-1) continue;
            q.offer(new int[]{cur[0], nums2[cur[2] + 1], cur[2] + 1});  
        }
        return res;
    }
}