import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class BankAccount extends Account{
    ArrayList<Transaction> history;
    public BankAccount(int accNo, double blc, String name, String accType, String curr) {
        super(accNo, blc, name, accType, curr);
        history = new ArrayList<>();
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount);
        LocalDateTime localDateTime = LocalDateTime.now();
        history.add(new Transaction(localDateTime, amount, currency));
    }

    @Override
    public void withdraw(double amount) {
        super.withdraw(amount);
        LocalDateTime localDateTime = LocalDateTime.now();
        history.add(new Transaction(localDateTime, amount, currency));
    }

    public void printStatement(){
        for (Transaction transaction : history) {
            System.out.println(transaction.toString());
        }
    }
}
