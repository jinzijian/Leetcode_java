class Solution {
    private int m;
    private int n;
    public void solve(char[][] board) {
        if(board == null || board.length == 0) return;
        m = board.length;
        n = board[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'O' && isEdge(i,j)){
                    floodfill(board, i , j);
                }
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == '1'){
                    board[i][j] = 'O';
                }else{
                    board[i][j] = 'X';
                }
            }
        }

        return;
    }
    private boolean isEdge(int i, int j){
        return(i == 0 || j == 0 || i == m - 1 || j == n - 1);
    }
    private void floodfill(char[][] board, int x, int y){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x * n + y);
        board[x][y] = '1';
        while(!queue.isEmpty()){
            int cur = queue.poll();
            int i = cur / n;
            int j = cur % n;
            if(i > 0 && board[i-1][j] == 'O'){
                queue.offer((i-1) * n + j);
                board[i-1][j] = '1';
            }
            if(i < m - 1 && board[i + 1][j] == 'O'){
               queue.offer((i+1) * n + j);
               board[i+1][j] = '1';
           }
           if(j > 0 && board[i][j - 1] == 'O'){
               queue.offer(i * n + j - 1);
               board[i][j - 1] = '1';
           }
           if(j < n - 1 && board[i][j + 1] == 'O'){
               queue.offer(i * n + j + 1);
               board[i][j + 1] = '1';
           }
        }

    }
}