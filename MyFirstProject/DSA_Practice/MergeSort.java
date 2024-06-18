package DSA_Practice;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    private static List<Integer> MergeSort(List<Integer> arr, int s, int e) {
        // Return when only single element is left in an array
        if(s == e)
            return List.of(arr.get(s));

        // Find mid of an array
        int mid = (s + e) / 2;

        // Split arr
        List<Integer> left = MergeSort(arr, s, mid);
        List<Integer> right= MergeSort(arr, mid + 1, e);

        // Merge left and right parts
        int i = 0, j = 0;
        List<Integer> merged = new ArrayList<Integer>();
        while(i < left.size() && j < right.size() ){
            if(left.get(i) < right.get(j)){
                merged.add(left.get(i));
                i++;
            }
            else{
                merged.add(right.get(j));
                j++;
            }
        }
        while(i < left.size()){
            merged.add(left.get(i));
            i++;
        }
        while(j < right.size()){
            merged.add(right.get(j));
            j++;
        }
        return merged;
    }
    public static void main(String[] args) {
        //List<Integer> arr = List.of(4,2,7,3,5,9,1,2);
        List<Integer> arr = List.of(3,2,1);
        System.out.println(MergeSort(arr, 0, arr.size() - 1));
    }
}
