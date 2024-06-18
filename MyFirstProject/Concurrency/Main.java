package Concurrency;

import java.util.List;
import java.util.concurrent.*;

class Abhijeet implements Runnable{
    private int num;

    Abhijeet(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " " + num);
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Integer> numbers = List.of(4,2,7,1,9,3,5);
        MergeSorter mergeSorter = new MergeSorter(numbers, executorService);
        Future<List<Integer>> sortedListFuture = executorService.submit(mergeSorter);
        List<Integer> sortedList = sortedListFuture.get();
        System.out.println(sortedList);
        executorService.shutdown();
//        for(int i=0;i<100;i++) {
//            Abhijeet abhijeet = new Abhijeet(i);
//            executor.execute(abhijeet);
//            Thread t = new Thread(abhijeet);
//            System.out.println(t.getState());
//            t.start();
//            System.out.println(t.getState());
        //}
        //executor.shutdown();

    }
}

