//注意这个题是输出一个就行
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || numCourses == 0) return new int[0];
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
        //判断是否有环
        if(res.size() != numCourses) return new int[0];
        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            result[i] = res.get(i);
        }
        return result;
    }
    
}