import java.util.concurrent.atomic.AtomicInteger;

public class Example_Five {
    static AtomicInteger atomicInteger = new AtomicInteger(0);
    public static void main(String[] args) throws Exception {
        for (int j = 0; j < 10_000 ; j++) {
            new MyThread_Five().start();
        }
        Thread.sleep(2_000);
        System.out.println(atomicInteger.get());
    }
    static class MyThread_Five extends Thread {
        @Override
        public void run() {
          atomicInteger.incrementAndGet();
        }
    }
}


