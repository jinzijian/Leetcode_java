//简单粗暴 大顶堆
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>((a, b) -> (b.get(0) + b.get(1) - a.get(0) - a.get(1)));
        for(int i = 0; i < Math.min(nums1.length, k); i++){
            for(int j = 0; j < Math.min(nums2.length, k); j++){
                if(queue.size() == k && nums1[i] + nums2[j] > queue.peek().get(0) + queue.peek().get(1)) break;
                if(queue.size() == k){
                    queue.poll();
                }
                List<Integer> pair = new ArrayList<>();
                pair.add(nums1[i]);
                pair.add(nums2[j]);
                queue.add(pair);
            }
        }
        List<List<Integer>> res = new LinkedList<>();
        for(int i =0; i < k && !queue.isEmpty(); i++){
            //倒序操作
            res.add(0, queue.poll());
        }
        return res;
    }
}