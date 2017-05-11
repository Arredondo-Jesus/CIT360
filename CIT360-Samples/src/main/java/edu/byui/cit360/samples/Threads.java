/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.byui.cit360.samples;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 *
 * @author Jesus Arredondo
 */
public class Threads {

    public void executeThread() {
        Runnable task = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello " + threadName);
        };

        task.run();

        Thread thread = new Thread(task);
        thread.start();

        System.out.println("Done!");
    }

    public void runThreadSleep() {
        Runnable runnable = () -> {
            try {
                String name = Thread.currentThread().getName();
                System.out.println("Foo " + name);
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Bar " + name);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }

    public ExecutorService runExecutor() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            //executeLoop(executor);
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello " + threadName);
        });

        return executor;
    }

    public void stopExecutor(ExecutorService executor) {
        try {
            System.out.println("attempt to shutdown executor");
            executor.shutdown();
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.err.println("tasks interrupted");
        } finally {
            if (!executor.isTerminated()) {
                System.err.println("cancel non-finished tasks");
            }
            executor.shutdownNow();
            System.out.println("shutdown finished");
        }
    }

    public void executeLoop(ExecutorService executor) {
        int counter = 0;
        String threadName = Thread.currentThread().getName();

        while (0 == 0) {
            counter = counter + 1;
            System.out.println("This is thread " + threadName);
        }

    }

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        Threads timer = new Threads();
        ExecutorService executor1 = timer.runExecutor();
        ExecutorService executor2 = timer.runExecutor();
        int threads = Thread.activeCount();
        System.out.println("Tha approximate number of threads is " + threads);
    }

}
