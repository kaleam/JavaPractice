package Heaps;

import java.util.PriorityQueue;

public class ConnectRopes {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] A = new int[] { 5, 17, 100, 11 };

        for (int i = 0; i < A.length; i++) {
            pq.add(A[i]);
        }
        int ans = 0;
        while (pq.size() != 1) {
            int rope1 = pq.remove();
            int rope2 = pq.remove();
            int sum = rope1 + rope2;
            ans += sum;
            pq.add(sum);
        }
        System.out.println(ans);
    }
}
