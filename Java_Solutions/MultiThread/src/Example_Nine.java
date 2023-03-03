import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Example_Nine {
    public static void main(String[] args) throws Exception{
        Resources resource = new Resources();
        resource.i = 5;
        resource.j = 5;
        MyThread_Nine myThread_nine1 = new MyThread_Nine();
        myThread_nine1.setName("one");
        MyThread_Nine myThread_nine2 = new MyThread_Nine();
        myThread_nine1.resource = resource;
        myThread_nine2.resource = resource;
        myThread_nine1.start();
        myThread_nine2.start();
        myThread_nine1.join();
        myThread_nine2.join();
        System.out.println(resource.i);
        System.out.println(resource.j);
    }
    static class MyThread_Nine extends Thread {
        Resources resource;

        @Override
        public void run() {
            resource.changeI();
            resource.changeJ();
        }
    }
}


class Resources {

    int i;
    int j;

    Lock lock = new ReentrantLock();

   void changeI() {
        lock.lock();
        int i = this.i;
        if (Thread.currentThread().getName().equals("one")) {
            Thread.yield();
        }
        i++;
        this.i = i;
    }
    void changeJ() {
        int j = this.j;
        if (Thread.currentThread().getName().equals("one")) {
            Thread.yield();
        }
        j++;
        this.j = j;
        lock.unlock();
    }
}
