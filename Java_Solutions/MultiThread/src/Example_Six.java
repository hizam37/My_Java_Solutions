import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Example_Six {
    public static void main(String[] args) throws Exception {
        NameList nameList = new NameList();
        nameList.add("first");
        class MyThread_Six extends Thread {
            @Override
            public void run() {
                System.out.println(nameList.removeFirst());
            }
        }
        MyThread_Six myThread_six= new MyThread_Six();
        myThread_six.setName("one");
        myThread_six.start();
        new MyThread_Six().start();
    }

    static class NameList {
        private List list = Collections.synchronizedList(new ArrayList<>());

        public synchronized void add(String name)
        {
            list.add(name);
        }

        public synchronized String removeFirst(){
            if(list.size()>0)
            {
                if(Thread.currentThread().getName().equals("one")){
                    Thread.yield();
                }
                return (String)list.remove(0);
            }
            return null;
        }
    }
}
