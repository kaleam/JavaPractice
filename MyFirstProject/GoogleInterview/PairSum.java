package GoogleInterview;

import java.util.Arrays;

public class PairSum {
    private int countPairs(int[] arr, int k) {
        Arrays.sort(arr);
        int count = 0;
        int i = 0, j = arr.length - 1;
        while (i < j) {
            int sum = arr[i] + arr[j];
            if (sum == k) {
                count++;
                i++;
                j--;
            } else if (sum < k) {
                i++;
            } else {
                j--;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        PairSum pairSum = new PairSum();
        System.out.println(pairSum.countPairs(new int[]{1, 2, 3, 4, 5, 2, 1, 1}, 3));
    }
}
