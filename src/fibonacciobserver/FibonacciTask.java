package ex2;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class FibonacciTask extends Thread{
    private long tal;
    
    List<FibonacciObserver> observers = new ArrayList();
    public long fib(long n) {
    if ((n == 0) || (n == 1)) {
      return n;
    } else {
      return fib(n - 1) + fib(n - 2);
    }
  }
    
    public void registerFibonacciObserver(FibonacciObserver o){
      observers.add(o);
    }
    
    
    public FibonacciTask(long n) {
        this.tal = n;
    }
    
    
    
    public synchronized void run() {
        //Call the Fibonacci method from here
        //long tal = ......
        long pe = fib(tal);        
        for(FibonacciObserver observer : observers){
          observer.dataReady(pe);
        }
          notify();
    }
    
    
    
}
