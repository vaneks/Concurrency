package main.java.com.vaneks.multiThread.task2;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class FizzBuzz {
    int n;
    CyclicBarrier cbar;
    public FizzBuzz(int n, CyclicBarrier cb) {
        this.n = n;
        cbar = cb;
    }

    public void fizzbuzz(int n) {
        if ((n % 3 == 0) && (n % 5 == 0)) System.out.println("fizzbuzz");
        try {
            cbar.await();
        } catch (BrokenBarrierException e) {
            System.out.println(e);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void fizz(int n) {
        if ((n % 3 == 0) && (n % 5 != 0)) System.out.println("fizz");
        try {
            cbar.await();
        } catch (BrokenBarrierException e) {
            System.out.println(e);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void buzz(int n) {
        if ((n % 5 == 0) && (n % 3 != 0)) System.out.println("buzz");
        try {
            cbar.await();
        } catch (BrokenBarrierException e) {
            System.out.println(e);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void number(int n) {
        if ((n % 5 != 0) && (n % 3 != 0)) System.out.println(n);
        try {
            cbar.await();
        } catch (BrokenBarrierException e) {
            System.out.println(e);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
