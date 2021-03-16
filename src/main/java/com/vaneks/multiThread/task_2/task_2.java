package main.java.com.vaneks.javacore.multi2;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class FizzBuzz {
    int n;
    public FizzBuzz(int n) {
        this.n = n;
    }

    public void fizzbuzz(int n) {
        if((n % 3 == 0) && (n % 5 == 0)) System.out.println("fizzbuzz");
    }
    public void fizz(int n) {
        if((n % 3 == 0) && (n % 5 != 0))  System.out.println("fizz");
    }
    public void buzz(int n) {
        if((n % 5 == 0) && (n % 3 != 0))  System.out.println("buzz");
    }
    public void number(int n) {
        if((n % 5 != 0) && (n % 3 != 0)) System.out.println(n);
    }
}
class Multi implements Runnable {
    FizzBuzz fizzBuzz;
    CyclicBarrier cbar;
    String name;
    int n;

    Multi(FizzBuzz fizzBuzz,CyclicBarrier c, String name, int n) {
        this.fizzBuzz = fizzBuzz;
        cbar = c;
        this.name = name;
        this.n = n;
    }
    @Override
    public void run() {

        for (int i = 1; i <= n; i++) {
            if(name=="fizzbuzz")fizzBuzz.fizzbuzz(i);
            if(name=="fizz")fizzBuzz.fizz(i);
            if(name=="buzz")fizzBuzz.buzz(i);
            if(name=="number")fizzBuzz.number(i);
            try {
                cbar.await();
            } catch (BrokenBarrierException e) {
                System.out.println(e);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class task_2 {
    public static void main(String[] args) {
        int n = 15;
        CyclicBarrier cb = new CyclicBarrier(4);
        FizzBuzz fizzBuzz = new FizzBuzz(n);
        new Thread(new Multi(fizzBuzz, cb, "fizzbuzz",n)).start();
        new Thread(new Multi(fizzBuzz, cb, "fizz",n)).start();
        new Thread(new Multi(fizzBuzz, cb, "buzz",n)).start();
        new Thread(new Multi(fizzBuzz, cb, "number",n)).start();
    }
}