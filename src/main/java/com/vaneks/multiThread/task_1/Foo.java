package main.java.com.vaneks.multiThread.task_1;

import java.util.concurrent.Semaphore;

class Foo {
    static Semaphore first = new Semaphore(1);
    static Semaphore second = new Semaphore(0);
    static Semaphore third = new Semaphore(0);

    public void first() {
        try {
            first.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("first");
        first.release();
        second.release();
    }
    public void second() {
        try {
            second.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("second");
        third.release();
    }
    public void third() {
        try {
            third.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("third");
    }
}
