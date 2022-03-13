package io.arkvaer.javaplayground.playground.base;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class MyCallable {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MineCallable mc = new MineCallable();
        FutureTask<Integer> futureTask = new FutureTask<>(mc);
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println(futureTask.get());
    }
}

class MineCallable implements Callable<Integer> {
    public Integer call() {
        return 123;
    }
}
