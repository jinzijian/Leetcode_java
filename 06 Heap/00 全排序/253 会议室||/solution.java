//开始时间排序
//结束时间建堆
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return 0;
        int count = 1;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int end = intervals[0][1];
        PriorityQueue<Integer> p = new PriorityQueue<>(intervals.length,(a,b)->a-b);
        p.add(intervals[0][1]);
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] >= p.peek()){
                p.poll();
            }
            p.add(intervals[i][1]);
        }
        return p.size();
    }
}