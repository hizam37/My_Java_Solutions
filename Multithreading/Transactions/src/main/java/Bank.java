import lombok.Getter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Getter
public class Bank {

    private Map<String, Account> accounts;
    private final Random random = new Random();

    public Bank(Map<String, Account> accounts) {
        this.accounts = accounts;
    }

    public boolean isFraud(String fromAccountNum, String toAccountNum, long amount)

            throws InterruptedException {

        Thread.sleep(1000);

        return random.nextBoolean();

    }

    public void transfer(String fromAccountNum, String toAccountNum, long amount) {

        synchronized (fromAccountNum.compareTo(toAccountNum) > 0 ? toAccountNum : fromAccountNum) {

            synchronized (fromAccountNum.compareTo(toAccountNum) > 0 ? fromAccountNum : toAccountNum) {

                if (amount > 50000) {

                    try {

                        if (isFraud(fromAccountNum, toAccountNum, amount)) {

                            accounts.get(fromAccountNum).setBlocked(true);

                            accounts.get(toAccountNum).setBlocked(true);

                            System.out.println("Accounts are blocked due to Fraud act between Account number " +
                                    fromAccountNum + " and Account number "
                                    + toAccountNum);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    if (accounts.get(fromAccountNum).getMoney() >= amount) {

                        accounts.get(fromAccountNum).setMoney(accounts.get(fromAccountNum).getMoney() - amount);

                        accounts.get(toAccountNum).setMoney(accounts.get(toAccountNum).getMoney() + amount);

                        System.out.println("Received from account " + fromAccountNum + " balance " + accounts.get(fromAccountNum).getMoney() + " to account " + toAccountNum +
                                " is now " + accounts.get(toAccountNum).getMoney());

                    }else {
                        System.out.println("not enough balance");
                    }

                }
            }
        }

    }

    public synchronized long getBalance(String accountNum) {
        return this.accounts.get(accountNum).getMoney();
    }


    public  long getSumAllAccounts()
    {
        long sum = 0;
        for (Account account : accounts.values())
        {
            sum += account.getMoney();
        }
        return sum;
    }



    public String getAccountRandomly(Map<String ,Account> accounts)
    {
        return accounts.keySet().toArray(new String[0])[ (int) (Math.random()* accounts.size())];
    }
}


