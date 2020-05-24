//小顶堆类比lc23题
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums2.length == 0 || nums2.length ==0) return res;
        //注意：存入的是坐标-》要带入后比较
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> (nums1[a[0]] + nums2[a[1]] - nums1[b[0]] - nums2[b[1]]));
        for(int i = 0; i < Math.min(k, nums1.length); i++){
            queue.offer(new int[] {i , 0});
        }
        while(k > 0 && !queue.isEmpty()) {
            int[] cur = queue.poll();
            List<Integer> tmp = new ArrayList<>();
            tmp.add(nums1[cur[0]]);
            tmp.add(nums2[cur[1]]);
            res.add(tmp);
            if(cur[1] < nums2.length - 1){
                queue.offer(new int[] {cur[0], cur[1] + 1});
            }
            k--;
        }
        return res;
    }
}