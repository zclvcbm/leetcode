package test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Admin on 2016/7/29.
 */
public class GetMidNum {
    private int count = 0;
    private PriorityQueue<Integer> minHeap = new PriorityQueue();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue(15, new Comparator<Integer>(){
        public int compare(Integer l1, Integer l2){
            return l2-l1;
        }
    });

    public void Insert(Integer num) {
        if(count%2==0){
            maxHeap.offer(num);
            int filterMaxNum = maxHeap.poll();
            minHeap.offer(filterMaxNum);
        }else{
            minHeap.offer(num);
            int filterMinNum = minHeap.poll();
            maxHeap.offer(filterMinNum);
        }
        count++;
    }

    public Double GetMedian() {
        if(count%2==0)
            return new Double((minHeap.peek()+maxHeap.peek()))/2;
        else
            return new Double(minHeap.peek());
    }

}
