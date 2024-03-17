package Heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class MaxHeap {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int[] A = new int[] { 5, 17, 100, 11 };

        for (int i = 0; i < A.length; i++) {
            pq.add(A[i]);
        }
        while (!pq.isEmpty()) {
            System.out.println(pq.remove());
        }
    }
}
