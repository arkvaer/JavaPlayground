package io.arkvaer.javaplayground.playground.base;

public class StopTheThread {
    public static void main(String[] args) {
        MyThreads myThreads = new MyThreads();
        myThreads.start();
    }
}


class MyThreads extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(3000);
            for (int i = 0; i < 10; i++) {
                if (i == 6) {
                    Thread.yield();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}