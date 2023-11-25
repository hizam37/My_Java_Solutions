import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Loader {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int cores = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(cores);
        executorService.submit(() -> {
            try {
                for (int i = 0; i < 1; i++) {
                    PrintWriter writer = new PrintWriter("res/NUMBERS " + i + ".txt");
                    char letters[] = {'У', 'К', 'Е', 'Н', 'Х', 'В', 'А', 'Р', 'О', 'С', 'М', 'Т'};
                    StringBuilder stringBuilder = new StringBuilder();
                    for (int regionCode = 1; regionCode <= 199; regionCode++) {
                        stringBuilder.delete(0, stringBuilder.length());
                        for (int number = 1; number < 1000; number++) {
                            for (char firstLetter : letters) {
                                for (char secondLetter : letters) {
                                    for (char thirdLetter : letters) {
                                        stringBuilder.append(firstLetter)
                                                .append(padNumber(number, 3))
                                                .append(secondLetter)
                                                .append(thirdLetter)
                                                .append(padNumber(regionCode, 2))
                                                .append("\n");
                                    }
                                }
                            }
                        }
                        writer.write(stringBuilder.toString());
                    }
                    writer.flush();
                    writer.close();
                    System.out.println(System.currentTimeMillis() - start);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        executorService.shutdown();

        try {
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static String padNumber(int number, int numberLength) {
        String numberStr = Integer.toString(number);
        int padSize = numberLength - numberStr.length();

        for (int i = 0; i < padSize; i++) {
            numberStr = '0' + numberStr;
        }

        return numberStr;
    }
}