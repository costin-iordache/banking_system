import java.util.ArrayList;
import java.util.Random;

public class Customer {
    String name;
    String email;
    ArrayList<Account> accounts;
    public Customer(){
        name = "";
        email = "";
        accounts = new ArrayList<>();
    }
    public Customer(String name, String email){
        this.name = name;
        this.email = email;
        this.accounts = new ArrayList<>();
    }
    public void addAccount(String accType, String curr){
        int accNo = (int)((Math.random() * (9999 - 1000)) + 1000);
        accounts.add(new Account(accNo, 0, name, accType,curr));
    }
    public void removeAccount(Account acc){
        accounts.remove(acc);
    }
    public void getAccountInfo(){
        System.out.println("Numele clientului: " + name);
        System.out.println("Email: " + email);
        System.out.println("Conturi: " + accounts);
    }
}
