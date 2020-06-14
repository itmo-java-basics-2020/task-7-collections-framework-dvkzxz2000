package ru.ifmo.collections;

import java.util.PriorityQueue;

/**
 * Design a class to find the kth largest element in a stream. k is from 1 to numbers.length.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Constructor accepts an integer k and an integer array numbers, which contains initial elements from the stream.
 * For each call to the method KthLargest.add(), return the element representing the kth largest element in the stream.
 */
public class KthLargest {

    private int k;

    private PriorityQueue<Integer> queue;

    public KthLargest(int k, int[] numbers) {
        queue = new PriorityQueue<>();
        this.k = k;
        for (int i : numbers) {
            add(i);
        }
    }

    public int add(int x) {
        if (queue.size() > k - 1) {
            if (queue.peek() != null && queue.peek() > x - 1) {
                return queue.peek();
                //System.out.println(queue.peek());
            }
            queue.poll();
        }
        queue.add(x);
        return queue.peek();
        //System.out.println(queue.peek());
    }
}
