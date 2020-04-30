//超时
class Solution {
    private int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public int[][] updateMatrix(int[][] matrix) {
        int m  = matrix.length;
        int n = matrix[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0) continue;
                if(matrix[i][j] != 0){
                    matrix[i][j] = bfs(matrix, i, j);
                }
            }
        }
        return matrix;

    }
    private int bfs(int[][] matrix, int x, int y){
        int m  = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x * n + y);
        visited[x][y] = true;
        int count = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            //注意这里的计数，要一层记一次
            count++;
            for(int i = 0; i < size; i++){
                int cur = queue.poll();
                int oldx = cur / n;
                int oldy = cur % n;
                for(int k = 0; k < 4; k++){
                    int newx = oldx + directions[k][0];
                    int newy = oldy + directions[k][1];
                    if( newx >= 0 && newx < m && newy >=0 && newy < n && matrix[newx][newy] == 0){
                        return count;
                    }
                    if(newx >= 0 && newx < m && newy >=0 && newy < n && !visited[newx][newy]){
                        queue.offer(newx * n + newy);
                        visited[newx][newy] = true;
                    }
                }
            }
        }
        return count; 
    }
}