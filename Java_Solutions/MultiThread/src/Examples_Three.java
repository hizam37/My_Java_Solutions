import com.sun.source.tree.SynchronizedTree;

public class Examples_Three {
    public static void main(String[] args) throws Exception{
        Resource resource = new Resource();
        resource.i = 5;
        MyThread_Three myThread_three = new MyThread_Three();
        myThread_three.setName("one");
        MyThread_Three myThread_three2 = new MyThread_Three();
        myThread_three.start();
        myThread_three2.start();
        myThread_three.join();
        myThread_three2.join();
        System.out.println(resource.i);
    }
}

class MyThread_Three extends Thread {
    Resource resource;

    @Override
    public void run() {
        Resource.changeStaticI();
    }
}

class Resource {

    static int i;

    public synchronized static void changeStaticI() {
        synchronized (Resource.class) {
            int i = Resource.i;
            if (Thread.currentThread().getName().equals("one")) {
                Thread.yield();
            }
            i++;
            Resource.i = i;
        }
    }
    public void changeI() {
        synchronized (this) {
            int i = Resource.i;
            if (Thread.currentThread().getName().equals("one")) {
                Thread.yield();
            }
            i++;
            Resource.i = i;
        }
    }
}

