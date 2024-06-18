package Concurrency;

import java.util.concurrent.Semaphore;

public class FooBar {
    private int n;
    private Semaphore fooS;
    private Semaphore barS;

    public FooBar(int n){
        this.n = n;
        this.fooS = new Semaphore(1);
        this.barS = new Semaphore(0);
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for(int i = 0; i < n; i++){
            fooS.acquire();
            printFoo.run();
            fooS.release();
        }
    }
    public void bar(Runnable printBar) throws InterruptedException {
        for(int i = 0; i < n; i++){
            barS.acquire();
            printBar.run();
            barS.release();
        }
    }
}
