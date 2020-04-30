//拓扑排序
/* 
解题思路：既然要求最小高度，那么从我们直觉来看，结点肯定是在最内部的，
因为题目说了是无向图，所以越靠近边缘，高度肯定就会越大。
然后找几组数据，自己手动模拟一下，发现，最终的结点就是位于最中间的1个或2个结点
*/
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        //corner case
        if(n == 1){
            res.add(0);
            return res;
        }
        //构建map_用来之后构建邻接表
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(i, new ArrayList<>());
        }
        //统计入度
        Queue<Integer> queue = new LinkedList<>();
        int[] indegree = new int[n];
        for(int i = 0; i < edges.length; i++){
            indegree[edges[i][0]] += 1;
            indegree[edges[i][1]] += 1;
        // 构建邻接表
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }
        //把所有入度为1的放入栈中
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 1){
                queue.add(i);
            }
        }
        //逐层去除， 最后一层就是根节点
        while(!queue.isEmpty()){
            //分层操作记得要size
            int size = queue.size();
            res = new ArrayList<>();
            for(int i = 0; i < size; i++){
                int cur = queue.poll();
                res.add(cur);
                for(int neighbor : map.get(cur)){
                    indegree[neighbor]--;
                    if(indegree[neighbor] == 1){
                        queue.add(neighbor);
                    }
                }
            }
        }
        return res;
    }
}