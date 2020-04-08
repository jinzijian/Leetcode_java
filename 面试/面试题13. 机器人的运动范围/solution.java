class Solution {
    private List<int[]> directions = Arrays.asList(
        new int[] {-1, 0},
        new int[] {0, -1},
        new int[] {0, 1},
        new int[] {1, 0}
    );
    public int movingCount(int m, int n, int k) {
        int res = 0;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        queue.offer(new int[] {0, 0});
        res += 1;
        visited[0][0] = true;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int[] direction : directions){
                int i = cur[0] + direction[0];
                int j = cur[1] + direction[1];
                if(!isValid(i, j, m, n, k, visited)) continue;
                if(isValid(i, j, m, n, k, visited)){
                    res += 1;
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        return res;
    }
    private boolean isValid(int i, int j, int m, int n, int k, boolean[][] visited){
        int sum = countNumber(i) + countNumber(j);
        if(i < 0 || j < 0 || i >= m || j >= n || sum > k || visited[i][j] == true){
            return false;
        }
        return true;  
    }
    private int countNumber(int number){
        int sum = 0;
        while(number / 10 > 0){
            sum += number % 10;
            number = number/10;
        }
        sum += number;
        return sum;
    }
}