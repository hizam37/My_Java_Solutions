import java.io.File;

public class Main {

    private static int amountOfCores = Runtime.getRuntime().availableProcessors();
    private static int start = Thread.activeCount();

    private static long starting = System.currentTimeMillis();

    public static void main(String[] args) {

        String srcFolder = "/Users/DANIIL/Desktop/src";

        String dstFolder = "/users/DANIIL/Desktop/dst";

        File srcDir = new File(srcFolder);

        File[] files = srcDir.listFiles();

        int posIncrementer = 0;

        int partition = (files.length/ amountOfCores)+1;

        for (int i = 0; i < amountOfCores; i++) {

            int remaining = files.length-posIncrementer;

            int currentPartition = Math.min(partition,remaining);

            File[] files1 = new File[currentPartition];

            System.arraycopy(files,posIncrementer,files1,0,files1.length);

            posIncrementer+=currentPartition;

            ImageResizer imageResizer1 = new ImageResizer(files1, 800, 600, dstFolder,starting);

            new Thread(imageResizer1).start();

        }

        int initial = Thread.activeCount() - start;

        System.out.println("Amount of Thread is equivalent to amount of cores which equates to " + initial);

    }
}
