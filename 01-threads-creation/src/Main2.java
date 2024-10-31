/*
 * Copyright (c) 2019-2023. Michael Pogrebinsky - Top Developer Academy
 * https://topdeveloperacademy.com
 * All rights reserved
 */

/**
 * Threads Creation - Part 1, Thread Capabilities & Debugging
 * https://www.udemy.com/java-multithreading-concurrency-performance-optimization
 */
public class Main2 {

    public static void main(String [] args) {
        Thread t = new Thread(() -> {
            throw new RuntimeException("Intentional exception");
        });

        t.setName("Mis-behave thread");
        t.setUncaughtExceptionHandler( new Thread.UncaughtExceptionHandler(){
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("A critical error has happened: " + t.getName() + " error message: " + e.getMessage());
            }
        });

        t.start();
    }

}
