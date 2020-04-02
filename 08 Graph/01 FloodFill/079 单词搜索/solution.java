//图的dfs
class Solution {
    private int[][] directions = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    private boolean[][] marked;
    private int m;
    private int n;
    private char[][] board;
    private String word;
    public boolean exist(char[][] board, String word) {
        m = board.length;
        if(m == 0) return true;
        n = board[0].length;
        if(n == 0) return true;
        marked = new boolean[m][n];
        this.word = word;
        this.board = board;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                //重点是这里返回值的处理
                if(dfs(i, j, 0)) return true;
            }
        }
        return false;
    }
    private boolean dfs(int i, int j, int start){
        //递归结束条件
        if(start == word.length() - 1){
            return board[i][j] == word.charAt(start);
        }
        if(board[i][j] == word.charAt(start)){
            marked[i][j] = true;
            for(int[] d : directions){
                int x = i + d[0];
                int y = j + d[1];
                if(x < 0 || y < 0 || x >= m || y >= n || marked[x][y]) continue;
                //重点是这里返回值的处理
                if(dfs(x, y , start + 1)){
                    return true;
                }
            }
            marked[i][j] = false;
        }
        return false;
    }
}