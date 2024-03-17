package Heaps;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class AthLargestElement {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int A = 4;
        int[] B = new int[] { 1, 2, 3, 4, 5, 6 };
        // List<Integer> ans = new ArrayList<>();
        int[] ans = new int[B.length];

        for (int i = 0; i < A; i++) {
            pq.add(B[i]);
            ans[i] = -1;
        }

        for (int i = A; i < B.length; i++) {
            // int top = pq.peek();
            // ans[i] = top;
            // if (B[i] > top) {
            // pq.remove();
            // pq.add((B[i]));
            // }
            if (pq.size() > A)
                pq.poll();
            ans[i] = pq.peek();

        }

        System.out.println(ans);

    }
}
