//多源BFS
class Solution {
    private int empty = Integer.MAX_VALUE;
    private int gate = 0;
    private List<int[]> directions = Arrays.asList(
        new int[] {-1, 0},
        new int[] {0, -1},
        new int[] {0, 1},
        new int[] {1, 0}
    );
    public void wallsAndGates(int[][] rooms) {
        if(rooms == null || rooms.length == 0 || rooms[0] == null) return;
        int m = rooms.length;
        int n = rooms[0].length;
        Queue<int []> queue = new LinkedList<>();
        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j++){
                if(rooms[i][j] == gate){
                    queue.add(new int[] {i, j});
                }
            }
        }
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int[] direction : directions){
                int r = cur[0] + direction[0];
                int c = cur[1] + direction[1];
                if(r < 0 || c < 0 || r >= m || c >= n || rooms[r][c] != empty) continue;
                rooms[r][c] = rooms[cur[0]][cur[1]] + 1; 
                queue.offer(new int[] {r, c});
            }
        }

    }
}