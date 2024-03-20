import java.time.LocalDateTime;
import java.util.Date;

public class Transaction {
    LocalDateTime currentDate;
    double amount;
    String currency;
    public Transaction(LocalDateTime currentDate, double amount, String currency){
        this.currency = currency;
        this.amount = amount;
        this.currentDate = currentDate;
    }
    @Override
    public String toString(){
        return "Transaction completed. You paid " + amount + " " + currency + ". Date: " + currentDate;
    }
}
