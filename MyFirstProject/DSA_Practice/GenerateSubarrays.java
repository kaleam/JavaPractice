package DSA_Practice;

import java.util.ArrayList;
import java.util.List;

public class GenerateSubarrays {
    private static int[][] solve(int[] A) {
        int len = A.length;
        List<List<Integer>> subarrays = new ArrayList();
        for(int i=0;i<len;i++){
            for(int j=i;j<len;j++){
                List<Integer> subarray = new ArrayList();
                for(int k=i;k<=j;k++){
                    subarray.add(A[k]);
                }
                subarrays.add(subarray);
            }
        }

        int[][] ans = subarrays.stream().map(u -> u.stream().mapToInt(i -> i).toArray()).toArray(int[][]::new);
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        System.out.println(solve(arr));
    }
}
