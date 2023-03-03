import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class Example_Twelve {
    public static void main(String[] args) throws Exception {
        Callable<Integer> collable = new MyCallable();
        FutureTask futureTask = new FutureTask(collable);
        new Thread(futureTask).start();
        System.out.println(futureTask.get());
    }

    static class MyCallable implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            int j=0;
            for (j = 0; j < 10; j++) {
                Thread.sleep(500);
            }
            return j;
        }
    }
}
