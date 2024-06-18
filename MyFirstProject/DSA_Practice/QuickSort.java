package DSA_Practice;

public class QuickSort {
    private static int[] num = new int[]{3,4,2,5,7,1};

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                //swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }
        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;

        return i;
    }

    private static void quickSort(int[] arr, int low, int high) {
        if(low >= high) return;
        int pivot = partition(arr, low, high);
        quickSort(arr, low, pivot - 1);
        quickSort(arr, pivot + 1, high);
    }

    public static void main(String[] args) {
        quickSort(num, 0, num.length - 1);
        System.out.println(num);
    }
}
