//全联通
// 点比边多一个
class Solution {
    public boolean validTree(int n, int[][] edges) {
        if((edges.length ==0 && n>1) || (edges.length !=n-1)){
            return false;
        }
        else if(edges.length == 0 && n<=1){
            return true;
        }
        Map<Integer, Set<Integer>> graph = initializeGraph(n, edges);
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> hash = new HashSet<>();
        queue.offer(0);
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(Integer neighbor : graph.get(cur)){
                if(hash.contains(neighbor)) continue;
                hash.add(neighbor);
                queue.offer(neighbor);
            }
        }
        return hash.size() == n;
    }
    //转化为图
    private Map<Integer, Set<Integer>> initializeGraph(int n, int[][] edges){
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for(int i = 0; i < n; i++){
            graph.put(i, new HashSet<Integer>());
        }
        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        return graph;
    }
}