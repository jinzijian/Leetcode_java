//最大堆 最小堆
class MedianFinder {
    private int count;
    private PriorityQueue<Integer> maxheap;
    private PriorityQueue<Integer> minheap;
    /** initialize your data structure here. */
    public MedianFinder() {
        count = 0;
        maxheap = new PriorityQueue<>((a, b) -> (b-a));
        minheap = new PriorityQueue<>();
        
    }
    
    public void addNum(int num) {
        count += 1;
        maxheap.offer(num);
        minheap.offer(maxheap.poll());
        if(count % 2 != 0){
            maxheap.offer(minheap.poll());
        }
    }
    
    public double findMedian() {
        if ((count % 2) == 0) {
            // 如果两个堆合起来的元素个数是偶数，数据流的中位数就是各自堆顶元素的平均值
            return (double) (maxheap.peek() + minheap.peek()) / 2;
        } else {
            // 如果两个堆合起来的元素个数是奇数，数据流的中位数大顶堆的堆顶元素
            return (double) maxheap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */