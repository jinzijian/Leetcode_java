class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
        }
        //priorityqueue默认最小堆实现，poll出来是从小到大，这里题目要求从大到小所以要重写comaprator
        PriorityQueue<Map.Entry<Integer, Integer>> p = new PriorityQueue<>((a, b) -> (b.getValue() - (a.getValue())));
        // map的遍历方式是特殊的 for (Map.Entry<Integer, Integer> entry : map.entrySet()) {} 
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            p.add(entry);
        }
        List<Integer> res = new ArrayList<>();
        while(res.size() < k){
            Map.Entry<Integer, Integer> entry = p.poll();
            res.add(entry.getKey());
        }
        return res;
    }
}