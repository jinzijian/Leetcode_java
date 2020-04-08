class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //corner case
         if(prerequisites == null || numCourses == 0) return false;
        //prepare bfs
        List<Integer> res = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] indegree = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            map.put(i, new ArrayList<>());
        }
        for(int i = 0; i < prerequisites.length; i++){
            indegree[prerequisites[i][0]]++;
            //构建单向邻接表
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                queue.offer(i);
                res.add(i);
            }
        }
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int neighbor : map.get(cur)){
                indegree[neighbor]--;
                if(indegree[neighbor] == 0){
                    res.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
        return res.size() == numCourses;
    }
}