import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Example_Ten {
    static Lock lock = new ReentrantLock();
    public static void main(String[] args) throws InterruptedException{
        new Thread1().start();
        new Thread2().start();

    }
    static class Thread1 extends Thread {
        @Override
        public void run() {
            lock.lock();
            System.out.println(getName() + " Start Working");
            try {
                sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName() + " Stop Working");
            lock.unlock();
            System.out.println(getName() + " lock is released");
        }
    }

    static class  Thread2 extends Thread {
        @Override
        public void run() {
            System.out.println(getName() + " login Working");
            while (true) {
                if (lock.tryLock()) {
                    System.out.println(getName() + " Waiting ");
                    break;
                }else {
                    System.out.println(getName() + " Waiting");
                }
            }
        }
    }
}
