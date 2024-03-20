import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Account> accounts = new ArrayList<>();

        try {
            File f = new File("bank.csv");
            BufferedReader br = new BufferedReader(new FileReader(f));
            String line = br.readLine();
            if (line != null) {
                line = br.readLine();
            }
            while (line != null) {
                String[] tokens = line.split(",");
                if (Objects.equals(tokens[3], "bank")) {
                    BankAccount acc = new BankAccount(Integer.parseInt(tokens[0]), Double.parseDouble(tokens[1]), tokens[2], tokens[3], tokens[4]);
                    accounts.add(acc);
                } else {
                    SavingsAccount acc = new SavingsAccount(Integer.parseInt(tokens[0]), Double.parseDouble(tokens[1]), tokens[2], tokens[3], tokens[4], 5.0);
                    accounts.add(acc);
                }
                line = br.readLine();
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        while (true) {

            System.out.println("\n1. Deposit\n2. Withdraw\n3. Transfer\n4. Check Balance\n5. Print Statement\n6. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            if (choice == 6) {
                break;
            }

            System.out.print("Enter account number: ");
            int accountNumber = scanner.nextInt();
            Account selectedAccount = Account.findAccount(accounts, accountNumber);

            if (selectedAccount == null) {
                System.out.println("Account not found.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    selectedAccount.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    selectedAccount.withdraw(withdrawalAmount);
                    break;
                case 3:
                    System.out.print("Enter destination account number: ");
                    int destinationAccountNumber = scanner.nextInt();
                    Account destinationAccount = Account.findAccount(accounts, destinationAccountNumber);

                    if (destinationAccount == null) {
                        System.out.println("Destination account not found.");
                        continue;
                    }

                    System.out.print("Enter transfer amount: ");
                    double transferAmount = scanner.nextDouble();
                    selectedAccount.transferAmount(destinationAccount, transferAmount);
                    break;
                case 4:
                    System.out.println("Balance: " + selectedAccount.getBalance() + " " + selectedAccount.currency);
                    break;
                case 5:
                    if (selectedAccount instanceof BankAccount) {
                        ((BankAccount) selectedAccount).printStatement();
                    } else {
                        System.out.println("Statement not available for savings account.");
                    }
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }
    }
}