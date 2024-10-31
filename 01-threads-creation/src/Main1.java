/*
 * Copyright (c) 2019-2023. Michael Pogrebinsky - Top Developer Academy
 * https://topdeveloperacademy.com
 * All rights reserved
 */

/**
 *  Threads Creation - Part 1, Thread Capabilities & Debugging
 * https://www.udemy.com/java-multithreading-concurrency-performance-optimization
 */
public class Main1 {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            //Code runs here
            System.out.println("We are in thread: " + Thread.currentThread().getName());
            System.out.println("Thread priority: " + Thread.currentThread().getPriority());
        });
        t1.setName("Worker Thread");
        t1.setPriority(Thread.MAX_PRIORITY);
        System.out.println("We are in thread: " + Thread.currentThread().getName() + " before starting a new thread");
        t1.start();
        System.out.println("We are in thread: " + Thread.currentThread().getName() + " after starting a new thread");

        Thread.sleep(5000);
    }
}
