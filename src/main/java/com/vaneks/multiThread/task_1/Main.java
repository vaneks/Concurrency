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
class Method implements Runnable {
    Foo foo;
    String string;
    Method(Foo foo,String s){
        this.foo = foo;
        string = s;
    }
    public void run(){
        if(string=="1")foo.first();
        if(string=="2")foo.second();
        if(string=="3")foo.third();
    }
}

public class Main {
    public static void main(String[] args) {
        Foo foo = new Foo();
        new Thread(new Method(foo,"2")).start();
        new Thread(new Method(foo,"3")).start();
        new Thread(new Method(foo,"1")).start();
    }
}

