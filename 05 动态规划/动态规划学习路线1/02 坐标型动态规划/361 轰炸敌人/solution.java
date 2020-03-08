//技巧每个点从上下左右四个方向分析
//以上方为例当前格子遇到墙为0，遇到有格子的敌人为一；再加上当前格子上方的格子能炸掉的敌人数量
class Solution {
    public int maxKilledEnemies(char[][] grid) {
        //边界条件
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] up = new int[m][n];
        int[][] down = new int[m][n];
        int[][] left = new int[m][n];
        int[][] right = new int[m][n];
        // up 
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 'W'){
                    up[i][j] = 0;
                    continue;
                }
                up[i][j]  = 0;
                if(grid[i][j] == 'E'){
                    up[i][j] = 1;
                }
                if(i > 0){
                    up[i][j] += up[i-1][j];
                }
            }
        }
        // down 注意顺序
        for(int i = m-1; i >= 0; i--){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 'W'){
                    down[i][j] = 0;
                    continue;
                }
                down[i][j]  = 0;
                if(grid[i][j] == 'E'){
                    down[i][j] = 1;
                }
                if(i < m - 1){
                    down[i][j] += down[i+1][j];
                }
            }
        }
        // left
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 'W'){
                    left[i][j] = 0;
                    continue;
                }
                left[i][j]  = 0;
                if(grid[i][j] == 'E'){
                    left[i][j] = 1;
                }
                if(j > 0){
                    left[i][j] += left[i][j-1];
                }
            }
        }
        // right 注意顺序
        for(int i = 0; i < m; i++){
            for(int j = n-1; j >= 0; j--){
                if(grid[i][j] == 'W'){
                    right[i][j] = 0;
                    continue;
                }
                right[i][j]  = 0;
                if(grid[i][j] == 'E'){
                    right[i][j] = 1;
                }
                if(j < n - 1){
                    right[i][j] += right[i][j+1];
                }
            }
        }
        int res = 0;
        int t;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '0'){
                    t = up[i][j] + down[i][j] + left[i][j] + right[i][j];
                    res = Math.max(t, res);
                }
            }
        }
        return res;


    }
}