class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals.length == 0 || intervals.length == 1 || intervals == null) return true;
        Arrays.sort(intervals, (a,b) -> (a[0] - b[0]));
        for(int i = 0; i < intervals.length - 1; i++){
            if(intervals[i+1][0] < intervals[i][1]){
                return false;
            }
        }
        return true;
    }
}