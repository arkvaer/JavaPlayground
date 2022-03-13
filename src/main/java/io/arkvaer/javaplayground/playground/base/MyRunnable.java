package io.arkvaer.javaplayground.playground.base;

public class MyRunnable  {

    public static void main(String[] args) {
        MineRunnable instance = new MineRunnable();
        Thread thread = new Thread(instance);
        thread.start();
    }
}


class MineRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("hello my runnable");
    }
}