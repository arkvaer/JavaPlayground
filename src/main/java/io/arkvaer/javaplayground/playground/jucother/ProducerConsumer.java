package io.arkvaer.javaplayground.playground.jucother;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author waver
 *
 * 提供了阻塞的 take() 和 put() 方法：
 * 如果队列为空, take() 将阻塞，直到队列中有内容；
 * 如果队列为满, put() 将阻塞，直到队列有空闲位置
 */
public class ProducerConsumer {
    private static final BlockingQueue<String> queue = new ArrayBlockingQueue<>(5);

    private static class Producer extends Thread {
        @Override
        public void run() {
            try {
                queue.put("product");
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
            System.out.println("produce..");
        }
    }

    private static class Consumer extends Thread {
        @Override
        public void run() {
            try {
                queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
            System.out.println("consume..");
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            Producer producer = new Producer();
            producer.start();
        }

        for (int i = 0; i < 5; i++) {
            Consumer consumer = new Consumer();
            consumer.start();
        }

        for (int i = 0; i < 2; i++) {
            Producer producer = new Producer();
            producer.start();
        }
    }
}
