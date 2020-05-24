class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> (b - a));
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(queue.size() == k && matrix[i][j] >= queue.peek()) continue;
                if(queue.size() == k) queue.poll();
                queue.offer(matrix[i][j]);
            }
        }
        return queue.peek();
    }
}