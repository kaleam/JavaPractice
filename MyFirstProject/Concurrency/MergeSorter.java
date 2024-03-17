package Concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class MergeSorter implements Callable<List<Integer>> {
    private List<Integer> listToSort;
    private ExecutorService executorService;

    MergeSorter(List<Integer> listToSort, ExecutorService executorService) {
        this.listToSort = listToSort;
        this.executorService = executorService;
    }

    @Override
    public List<Integer> call() throws Exception {
        // ------ Merge sort logic -------

        // 1. Split the list
        List<Integer> leftHalfList = new ArrayList<Integer>();
        List<Integer> rightHalfList = new ArrayList<Integer>();

        if (this.listToSort.size() == 1)
            return this.listToSort;

        for (int i = 0; i < this.listToSort.size(); i++) {
            if (i < this.listToSort.size() / 2)
                leftHalfList.add(this.listToSort.get(i));
            else
                rightHalfList.add(this.listToSort.get(i));
        }

        // 2. Sort each list in separate threads using executor service
        MergeSorter leftMergSorter = new MergeSorter(leftHalfList, executorService);
        MergeSorter righMergeSorter = new MergeSorter(rightHalfList, executorService);

        Future<List<Integer>> leftSortedListFuture = executorService.submit(leftMergSorter);
        Future<List<Integer>> rightSortedListFuture = executorService.submit(righMergeSorter);

        List<Integer> leftSortedList = leftSortedListFuture.get();
        List<Integer> rightSortedList = rightSortedListFuture.get();

        // 3. Merge sorted list
        int i = 0, j = 0;
        List<Integer> sortedList = new ArrayList<Integer>();
        while (i < leftSortedList.size() && j < rightSortedList.size()) {
            if (leftSortedList.get(i) < rightSortedList.get(j)) {
                sortedList.add(leftSortedList.get(i));
                i++;
            } else {
                sortedList.add(rightSortedList.get(j));
                j++;
            }
        }
        while (i < leftSortedList.size()) {
            sortedList.add(leftSortedList.get(i));
            i++;
        }
        while (j < rightSortedList.size()) {
            sortedList.add(rightSortedList.get(j));
            j++;
        }

        return sortedList;
    }

}
