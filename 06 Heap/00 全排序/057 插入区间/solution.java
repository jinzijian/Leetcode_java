 class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals == null ){
            return new int[][]{};
        }
        int[][] l = new int[intervals.length + 1][newInterval.length];
        for(int i = 0; i < intervals.length; i++){
            l[i] = intervals[i];
        }
        l[intervals.length] = newInterval;
        return merge(l);
    }
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0){
            return new int[][]{};
        }
        Arrays.sort(intervals, (a,b) -> (a[0] - b[0]));
        //sort排序
        List<int[]> res = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int[] interval: intervals){
            if(interval[0] <= end){
                end = Math.max(interval[1], end);
            }else{
                res.add(new int[]{start, end});
                start = interval[0]; 
                end = interval[1];
            }
        }
        res.add(new int[]{start, end});
        return res.toArray(new int[][]{});
    }
}