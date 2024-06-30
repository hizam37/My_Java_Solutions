import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BankTest {
    private Bank bank;
    int accountsInRange;
    String toAcc;
    String fromAcc;
    Map<String, Account> accounts;
    @Before
    public void setUp() throws Exception {
        accounts = new HashMap<>();
        bank = new Bank(accounts);
        Random random = new Random();
        accountsInRange = 20;

        for (int i = 0; i < accountsInRange; i++) {
            accounts.put(String.valueOf(i), new Account(60000, String.valueOf(random.nextInt(100) * 100)));
        }


        long sumOfAllAccountsBefore = bank.getSumAllAccounts();
        System.out.println("Sum of all accounts before transaction " + sumOfAllAccountsBefore);

    }

    @Test
    public void transferWithoutFraud() {
        int cores = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(cores);
        for (int i = 0; i < 20; i++) {
            executorService.submit(() -> {
                fromAcc = bank.getAccountRandomly(bank.getAccounts());
                toAcc = bank.getAccountRandomly(bank.getAccounts());
                bank.transfer(fromAcc, toAcc, 1000);
            });
        }


        executorService.shutdown();

        try {
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long sumOfAllAccountsAfter = bank.getSumAllAccounts();
        System.out.println("Sum of all accounts after transaction " + sumOfAllAccountsAfter);

        //Checking that accounts were active during transactions
        Assert.assertFalse(accounts.get(fromAcc).isBlocked());
        Assert.assertFalse(accounts.get(toAcc).isBlocked());

    }

    @Test
    public void transferWithFraud() {
        int cores = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(cores);
        for (int i = 0; i < 10; i++) {
            executorService.submit(() -> {
                fromAcc = bank.getAccountRandomly(bank.getAccounts());
                toAcc = bank.getAccountRandomly(bank.getAccounts());
                bank.transfer(fromAcc, toAcc, 60000);
            });
        }


        executorService.shutdown();

        try {
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long sumOfAllAccountsAfter = bank.getSumAllAccounts();
        System.out.println("Sum of all accounts after transaction " + sumOfAllAccountsAfter);


        //Checking that accounts are were blocked during Fraud act
        Assert.assertTrue(accounts.get(fromAcc).isBlocked());
        Assert.assertTrue(accounts.get(toAcc).isBlocked());

    }


}