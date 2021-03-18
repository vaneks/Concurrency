package main.java.com.vaneks.multiThread.task2;

import java.util.concurrent.CyclicBarrier;

class Multi implements Runnable {
    FizzBuzz fizzBuzz;
    String name;
    int n;

    Multi(FizzBuzz fizzBuzz, String name, int n) {
        this.fizzBuzz = fizzBuzz;
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
        }
    }
}
public class Main {
    public static void main(String[] args) {
        int n = 15;
        CyclicBarrier cb = new CyclicBarrier(4);
        FizzBuzz fizzBuzz = new FizzBuzz(n, cb);
        new Thread(new Multi(fizzBuzz, "fizzbuzz",n)).start();
        new Thread(new Multi(fizzBuzz,  "fizz",n)).start();
        new Thread(new Multi(fizzBuzz, "buzz",n)).start();
        new Thread(new Multi(fizzBuzz, "number",n)).start();
    }
}
