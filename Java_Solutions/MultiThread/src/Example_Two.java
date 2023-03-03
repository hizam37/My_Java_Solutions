public class Example_Two {
    public static void main(String[] args) throws Exception {
        MyThread_Two myThread_two= new MyThread_Two();
        myThread_two.start();
        myThread_two.join();
        System.out.println("Main Thread");

    }
}

class MyThread_Two extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
    }
}


