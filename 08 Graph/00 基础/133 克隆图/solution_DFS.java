//为了防止多次遍历相同节点所以要用hashmap记录
//dfs方法
class Solution {
    public Node cloneGraph(Node node) {
        HashMap<Node, Node> map = new HashMap<>();
        return dfs(node, map);
    }
    private Node dfs(Node node, HashMap<Node, Node> map){
        if(node == null) return null;
        if(map.containsKey(node)) return map.get(node);
        Node clone = new Node(node.val, new ArrayList<>());
        map.put(node, clone);
        for(Node n: node.neighbors){
            clone.neighbors.add(dfs(n, map));
        }
        return clone;
    }
}