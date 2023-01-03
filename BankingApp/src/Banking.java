import java.util.*;
public class Banking {
    private int balance;
    private String prevTransaction;

    public Banking(int balance) {
        this.balance = balance;
    }

    public void deposit() {
        Scanner sc = new Scanner(System.in);
        System.out.println("How much would you like to deposit?");
        int deposit = sc.nextInt();
        this.balance = this.balance + deposit;
        System.out.println("Your new balance is " + this.getBalance());
        this.prevTransaction = "You deposited " + deposit + " and your new balance became " + this.balance;
    }

    public void withdraw() {
        Scanner sc = new Scanner(System.in);
        System.out.println("How much would you like to withdraw?");
        int withdrawal = sc.nextInt();
        this.balance = this.balance - withdrawal;
        System.out.println("Your new balance is " + this.getBalance());
        this.prevTransaction = "You withdrew " + withdrawal + " and your new balance became " + this.balance;
    }

    public String getPrevTransaction() {
        return this.prevTransaction;
    }

    public int getBalance() {
        return this.balance;
    }

    public static void main(String[] args) {
        boolean flag = true;
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the banking application! To start off, what is your balance?");
        int bal = scan.nextInt();
        Banking account = new Banking(bal);

        while (flag) {
            System.out.println("To check balance, type \'bal\'. For interest calculation, type \'interest\'. To withdraw money, type \'W\'. To deposit, type \'D\'. To view the previous transaction, type \'prev\'. Otherwise, type \'quit\' to quit the application");
            String answer = scan.nextLine();

            if (answer.equalsIgnoreCase("W")) {
                account.withdraw();
            }
            else if (answer.equalsIgnoreCase("D")) {
                account.deposit();
            }
            else if (answer.equalsIgnoreCase("prev")) {
                System.out.println(account.getPrevTransaction());
            }
            else if (answer.equalsIgnoreCase("bal")) {
                System.out.println(account.getBalance());
            }
            else if (answer.equalsIgnoreCase("interest")) {
                System.out.println("With a balance of " + account.getBalance() + " and a rate of 15 over 1 year your interest is: " + (account.getBalance() * 15 * 1)/100);
            }
            else if (answer.equalsIgnoreCase("quit")) {
                flag = false;
                System.out.println("Thank you for using the banking application. Goodbye!");
            }
        }
    }
}
