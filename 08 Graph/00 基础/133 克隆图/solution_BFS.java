//为了防止多次遍历相同节点所以要用hashmap记录
//bfs方法
class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Node, Node> map = new HashMap<>();
        Node clone = new Node(node.val, new ArrayList<>());
        map.put(node, clone);
        Deque<Node> queue = new LinkedList<>();
        queue.offer(node);
       while (!queue.isEmpty()) {
            Node tmp = queue.poll();
            for (Node n : tmp.neighbors) {
                if(!map.containsKey(n)){
                    map.put(n, new Node(n.val, new ArrayList<>()));
                    queue.offer(n);
                }
                map.get(tmp).neighbors.add(map.get(n));
            }
        }
        return clone;
    }
}

