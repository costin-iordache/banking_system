import java.util.ArrayList;

public class Account {
    int accountNumber;
    double balance;
    String ownerName;
    String accountType;
    String currency;
    public Account(int accNo, double blc, String name, String accType, String curr){
        accountNumber = accNo;
        balance = blc;
        ownerName = name;
        accountType = accType;
        currency = curr;
    }
    public void deposit(double amount){
        balance += amount;
    }
    public void withdraw(double amount){
        if(balance >= amount){
            balance -= amount;
        } else {
          System.out.println("Balanta insuficienta!");
        }
    }
    public double getBalance(){
        return balance;
    }
    public void transferAmount(Account destinationAccount, double amount){
        if(balance >= amount){
            withdraw(amount);
            destinationAccount.deposit(amount);
        } else {
            System.out.println("Balanta insuficienta!");
        }
    }
    public static Account findAccount(ArrayList<Account> accounts, int accountNumber) {
        for (Account account : accounts) {
            if (account.accountNumber == accountNumber) {
                return account;
            }
        }
        return null;
    }
}
