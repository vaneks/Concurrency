package main.java.com.vaneks.multiThread.task_1;

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