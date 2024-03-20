public class SavingsAccount extends Account{
    double interestRate;
    public SavingsAccount(int accNo, double blc, String name, String accType, String curr, double intrs) {
        super(accNo, blc, name, accType, curr);
        interestRate = intrs;
    }
    public void updateAmount(){
        deposit(balance * interestRate / 100);
    }
}
