/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
       // corner case
       if(node == null) return node;
       // getnode
       HashMap<Node, Node> map = new HashMap<>();
       List<Node> nodes = getNodes(node);
       // copy nodes
       for(Node n: nodes){
           map.put(n, new Node(n.val));
       }
       // copy edges 
       for(Node n : nodes){
           Node newnode = map.get(n);
           for(Node neighbor : n.neighbors){
               Node newneighbor = map.get(neighbor);
               newnode.neighbors.add(newneighbor);
           }
       }
       return map.get(node);
    }
    //bfs
    private List<Node> getNodes(Node node){
        Queue<Node> queue = new LinkedList<>();
        Set<Node> set = new HashSet<>();
        queue.offer(node);
        set.add(node);
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            for(Node neighbor : cur.neighbors){
                if(set.contains(neighbor)) continue;
                set.add(neighbor);
                queue.offer(neighbor);
            }
        }
        return new ArrayList<Node>(set);
    }
}