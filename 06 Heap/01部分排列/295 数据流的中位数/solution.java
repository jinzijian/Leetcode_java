//最大堆 最小堆
class MedianFinder {
    private int count;
    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;

    /** initialize your data structure here. */
    public MedianFinder() {
        count = 0;
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a, b) -> (b - a));
    }
    
    public void addNum(int num) {
        count++;
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        //注意这里是为奇数时判断
        if(count % 2 != 0) {
            maxHeap.offer(minHeap.poll());
        }

    }
    
    public double findMedian() {
        if(count % 2 == 0) return (double)(maxHeap.peek() + minHeap.peek()) / 2;
        else{
            return (double)maxHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */