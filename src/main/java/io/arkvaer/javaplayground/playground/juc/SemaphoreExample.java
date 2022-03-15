package io.arkvaer.javaplayground.playground.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author waver
 * @date 2022/3/15 下午2:03
 *
 *
 * Semaphore 类似于操作系统中的信号量，可以控制对互斥资源的访问线程数。
 * 以下代码模拟了对某个服务的并发请求，每次只能有 10 个客户端同时访问，请求总数为 1000。
 */
public class SemaphoreExample {
    public static void main(String[] args) {
        final int clientCount = 10;
        final int totalRequestCount = 1000;
        Semaphore semaphore = new Semaphore(clientCount);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < totalRequestCount; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(semaphore.availablePermits());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            });
        }
        executorService.shutdown();
    }
}
