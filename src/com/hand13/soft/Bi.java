package com.hand13.soft;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by hd110 on 2017/9/9.
 */
public class Bi {
    private CyclicBarrier  barrier;
    public Bi() {
        barrier = new CyclicBarrier(3,() ->{
            System.out.println("finished");
            try {
                Thread.sleep(3000);
            }
            catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        });
    }
    public void work() {
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(new Es());
            thread.start();
        }
    }
    public static void main(String[] args) {
        Bi bi = new Bi();
        bi.work();
    }
    class Es implements Runnable{
        @Override
        public void run() {
            System.out.println("hello");
            try {
                barrier.await();
                System.out.println("let's go");
            }
            catch (InterruptedException ioe) {
                ioe.printStackTrace();
            }
            catch (BrokenBarrierException bbe) {
                bbe.addSuppressed(new Exception());
            }
        }
    }
}
