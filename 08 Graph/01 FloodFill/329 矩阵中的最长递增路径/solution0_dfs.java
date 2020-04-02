//dfs超时
class Solution {
    private int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private int m;
    private int n;
    private List<List<Integer>> res = new ArrayList<>();
    private boolean[][] visited;
    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        if(m == 0) return 0;
        n = matrix[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                visited = new boolean[m][n];
                List<Integer> list = new ArrayList<>();
                list.add(matrix[i][j]);
                dfs(i, j, list, matrix);
            }
        }
        int len = 0;
        for(int i = 0; i < res.size(); i++){
            List<Integer> tmp = res.get(i);
            System.out.println(tmp);
            len = Math.max(tmp.size(), len);
        }
        return len;
    }
    private void dfs(int i, int j, List<Integer> list, int[][] nums){
        if(!isValid(i + 0, j+1, i, j, nums) && !isValid(i+1, j+0, i, j, nums) && !isValid(i-1, j, i, j, nums) && !isValid(i, j - 1, i, j, nums)){
            res.add(new ArrayList<>(list));
            return;
        }
        visited[i][j] = true;
        for(int[] d : directions){
            int newx = i + d[0];
            int newy = j + d[1];
            if(!isValid(newx, newy, i, j, nums)) continue;
            list.add(nums[i][j]);
            dfs(newx, newy, list, nums);
            visited[i][j] = false;
            list.remove(list.size() - 1);
        }

    }
    private boolean isValid(int i, int j, int oldi, int oldj, int[][] nums){
        if(i < 0 || j < 0 || i >= m || j >= n || visited[i][j] || nums[i][j] <= nums[oldi][oldj]){
            return false;
        }else{
            return true;
        }
    }
}