package io.arkvaer.javaplayground.playground.base;

/**
 * 守护线程是程序运行时在后台提供服务的线程，不属于程序中不可或缺的部分。
 * <p>
 * 当所有非守护线程结束时，程序也就终止，同时会杀死所有守护线程。
 * <p>
 * main() 属于非守护线程。
 * <p>
 * 在线程启动之前使用 setDaemon() 方法可以将一个线程设置为守护线程。
 */
public class MyDaemon {
    public static void main(String[] args) {
        Thread thread = new Thread(new MineRunnable());
        thread.setDaemon(true);
        thread.start();
        try {
            /*
             * sleep()
             * Thread.sleep(millisec) 方法会休眠当前正在执行的线程，millisec 单位为毫秒。
             * sleep() 可能会抛出 InterruptedException，因为异常不能跨线程传播回 main() 中，因此必须在本地进行处理。线程中抛出的其它异常也同样需要在本地进行处理。
             */
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
