
//个人总结
// （1）转化邻接表不熟
//（2）BFS套路不熟
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || numCourses == 0) return false;
        //构建存储结果
        List<Integer> res = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        //构建邻接表+indegree数组
        int[] indegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < prerequisites.length; i++){
            indegree[prerequisites[i][0]]+= 1;
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        // 入度为0 入队
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                queue.offer(i);
                res.add(i);
            }
        }
        // bfs---被指向一次 入度减一，减到0则说明安全
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int n : adj.get(cur)){
                indegree[n]--;
                if(indegree[n] == 0){
                    res.add(n);
                    queue.offer(n);
                }
            }
        }
        return res.size() == numCourses;
    }
    
}