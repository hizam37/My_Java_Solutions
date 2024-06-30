import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Loader implements Runnable{

    private int startRegion;

    private int endRegion;

    public Loader(int startRegion, int endRegion) {

        this.startRegion = startRegion;

        this.endRegion = endRegion;

    }

    @Override
    public void run() {

        long start = System.currentTimeMillis();

        try {
            PrintWriter writer = new PrintWriter("res/NUMBERS " +startRegion + " to " + endRegion + ".txt");

            char[] letters = {'Y', 'K', 'E', 'H', 'X', 'B', 'A', 'P', 'O', 'C', 'M', 'T'};

            StringBuilder stringBuilder = new StringBuilder();

            for (int regionCode = startRegion; regionCode <=endRegion; regionCode++) {

                String paddedRegions = padNumber(regionCode, 2);

                stringBuilder.delete(0,stringBuilder.length());

                for (int number = 1; number < 1000; number++) {

                    String paddedNumbers = padNumber(number, 3);

                    for (char firstLetter : letters) {

                        for (char secondLetter : letters) {

                            for (char thirdLetter : letters) {
                                stringBuilder.append(firstLetter)
                                        .append(paddedNumbers)
                                        .append(secondLetter)
                                        .append(thirdLetter)
                                        .append(paddedRegions)
                                        .append("\n");

                            }
                        }
                    }
                }

                writer.write(stringBuilder.toString());

            }

            writer.flush();

            writer.close();

            System.out.println("Total time: " + (System.currentTimeMillis() - start) + " ms");

        }

        catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static String padNumber(int number, int numberLength) {

        String numberStr = Integer.toString(number);

        int padSize = numberLength - numberStr.length();

        for(int i=0;i<padSize;i++) {
            numberStr = '0' + numberStr;
        }

        return numberStr;
    }

    public static void main(String[] args) {

        int numOfThreads = 4;

        int numOfRegionCodes = 199;

        int regionsPerThread = numOfRegionCodes/numOfThreads;

        ExecutorService executorService = Executors.newFixedThreadPool(numOfThreads);

        for(int i=0;i<numOfThreads;i++)
        {

            int startFromRegion = (i*regionsPerThread)+1;

            int toRegion = (i+1)*regionsPerThread;

            if(i==numOfThreads-1)
            {

                toRegion = numOfRegionCodes;

            }

            executorService.submit(new Loader(startFromRegion,toRegion));

        }

        executorService.shutdown();

        try {
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}