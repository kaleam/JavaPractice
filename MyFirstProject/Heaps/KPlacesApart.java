package Heaps;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KPlacesApart {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] A = new int[] { 2, 1, 17, 10, 21, 95, 3 };
        int B = 1;
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i <= B; i++) {
            pq.add(A[i]);
        }

        for (int i = B + 1; i < A.length; i++) {
            ans.add(pq.remove());
            pq.add((A[i]));
        }

        while (!pq.isEmpty()) {
            ans.add(pq.remove());
        }

        System.out.println(ans);
    }
}
