
import java.util.Scanner;

public class ATM {
    private double Balance;
    Scanner input = new Scanner(System.in);

    public ATM(double balance) {
        this.Balance = balance;
    }

    public void setBalance(double balance) {
        Balance = balance;
    }

    public double getBalance() {
        return Balance;
    }

    public void checkBalance() {
        System.out.println("Available balance is: $" +getBalance() );
        System.out.println("DO YOU WANT TO PERFORM ANOTHER TRANSACTION?");
        System.out.println("1- YES" + "\n" + "2- NO");

        int next = input.nextInt();
        if (!(next == 2)) {
            System.out.println();
        } else System.exit(12);
    }

    public void deposit() {
        System.out.println("enter deposit amount: ");
        double amount = input.nextDouble();

        if (amount > 0) {
            setBalance(getBalance() + amount);
            System.out.println("Successful deposited $" + amount);
            System.out.println("DO YOU WANT TO PERFORM ANOTHER TRANSACTION?");
            System.out.println("1- YES" + "\n" + "2- NO");

            int next = input.nextInt();
            if (!(next == 2)) {
                System.out.println();
            } else System.exit(12);

        } else
            System.out.print("Sorry, deposit amount must be greater than Zero");

    }
    public void withdrawal() {
        System.out.println("enter the amount you want to withdraw: ");
        double withdrawal = input.nextDouble();

        if(withdrawal <= getBalance()) {
            setBalance(getBalance() - withdrawal);
            System.out.println("withdrawal successful, take your cash!");
            System.out.println("DO YOU WANT TO PERFORM ANOTHER TRANSACTION?");
            System.out.println("1- YES" + "\n" + "2- NO");

            int next = input.nextInt();
            if (!(next == 2)) {
                System.out.println();
            } else System.exit(12);
        }
        else
            System.out.println("you have insufficient fund, kindly deposit into your balance.");
    }

    public void transfer() {
        System.out.println("""
                Select the bank you want to send to:
                1- Access Bank
                2- GtBank
                3- Zenith Bank""");
        String bank = input.next();

        while (!(bank.equals("1") || bank.equals("2") || bank.equals("3"))) {
            System.out.println("Invalid input please enter  a valid input");

            System.out.println("""
                    Select the bank you want to send to:
                    1- Access Bank
                    2- GtBank
                    3- Zenith Bank""");
            bank = input.next();
        }

        System.out.println("Enter Account number: ");
        String acctNo = input.next();

        while (!(acctNo.length() == 10)) {
            System.out.println("you have entered an invalid account number (account number must have 10 digits)");
            System.out.println("Enter a valid Account number: ");
            acctNo = input.next();
        }
        System.out.println("Enter transfer amount: ");
        int trsAmt = input.nextInt();

        while (!(trsAmt > 0 && trsAmt <= getBalance())) {
            System.out.println("transfer amount must be greater than 0 and less than or equal to balance");
            System.out.println("Enter a valid transfer amount: ");
            trsAmt = input.nextInt();
        }
        setBalance(getBalance() - trsAmt);
        System.out.println("Transfer successful!");
        System.out.println("successfully sent " + "$" + trsAmt + " to " + acctNo);
        System.out.println("DO YOU WANT TO PERFORM ANOTHER TRANSACTION?");
        System.out.println("1- YES" + "\n" + "2- NO");

        int next = input.nextInt();
        if (!(next == 2)) {
            System.out.println();
        } else System.exit(12);
    }

    public void exit() {
        System.out.println("Thanks for Banking with us!");
        System.exit(10);

    }
}
