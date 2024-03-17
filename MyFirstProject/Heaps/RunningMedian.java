package Heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class RunningMedian {
    public static void main(String[] args) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int[] A = new int[] { 5, 17, 100, 11 };

        int[] ans = new int[A.length];
        maxHeap.add(A[0]);
        ans[0] = A[0];

        for (int i = 1; i < A.length; i++) {
            if (A[i] < maxHeap.peek())
                maxHeap.add(A[i]);
            else
                minHeap.add(A[i]);

            // balance the heaps
            if (maxHeap.size() - minHeap.size() > 1)
                minHeap.add(maxHeap.remove());
            else if (minHeap.size() - maxHeap.size() > 0)
                maxHeap.add(minHeap.remove());

            System.out.println(maxHeap);
            System.out.println(minHeap);

            // find median
            // int totalSize = maxHeap.size() + minHeap.size()
            // if (totalSize % 2 == 0)
            // ans.add((maxHeap.peek() + minHeap.peek()) / 2);
            // else
            ans[i] = maxHeap.peek();

            // System.out.println(ans);
        }

        System.out.println(ans[0]);

    }
}
