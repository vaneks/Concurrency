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
class First implements Runnable {
    Foo foo;
    First(Foo foo){
        this.foo = foo;
        new Thread(this, "First").start();
    }
    public void run(){
        foo.first();
    }
}
class Second implements Runnable {
    Foo foo;
    Second(Foo foo){
        this.foo = foo;
        new Thread(this, "Second").start();
    }
    public void run(){
        foo.second();
    }
}
class Third implements Runnable {
    Foo foo;
    Third(Foo foo){
        this.foo = foo;
        new Thread(this, "Third").start();
    }
    public void run(){
        foo.third();
    }
}
public class Main {
    public static void main(String[] args) {
        Foo foo = new Foo();
        new Thread(new Second(foo)).start();
        new Thread(new Third(foo)).start();
        new Thread(new First(foo)).start();
    }
}

