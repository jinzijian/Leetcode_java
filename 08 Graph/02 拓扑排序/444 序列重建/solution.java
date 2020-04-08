class Solution {
    //边界条件太恶心了
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        //统计入度+邻接表
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] indegree = new int[org.length+1];
        for(int i = 1; i <= org.length; i++){
            map.put(i, new ArrayList<>());
        }
        int n = org.length;
        int count = 0;
        for (List<Integer> seq : seqs) {
            count += seq.size();
            if (seq.size() >= 1 && (seq.get(0) <= 0 || seq.get(0) > n))
                return false;
            for (int i = 1; i < seq.size(); i++) {
                if (seq.get(i) <= 0 || seq.get(i) > n)
                    return false;
                if (map.get(seq.get(i-1)).add(seq.get(i)))
                    indegree[seq.get(i)]++;
            }
        }
        // case: [1], []
        if (count < n)
            return false;

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i < indegree.length; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }
        int cnt = 0;
        while(!queue.isEmpty()){
            if(queue.size() != 1) return false;
            int cur = queue.poll();
            for(int n1 : map.get(cur)){
                indegree[n1]--;
                if(indegree[n1] == 0){
                    queue.offer(n1);
                }
            }
            if(cur != org[cnt]) return false;
            cnt++;
        }
        //避免有环
        return cnt == org.length;
    }
}