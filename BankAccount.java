import java.util.Scanner;

public class BankAccount {
    int accno;
    double balance;

    Scanner sc=new Scanner(System.in);
    BankAccount (int acc,double bal)
    {
        this.accno=acc;
        this.balance=bal;
    }

    void withdraw() throws Exception
    {
        double amount;

        System.out.println("Enter the amount");
        amount=sc.nextInt();
        try {
            if (balance >= amount) {
                balance = balance - amount;
                System.out.println("After withdrawal remaining balance is:" + balance);
            } else {
                throw new Exception();
            }
        }catch(NullPointerException e)
        {
            System.out.println("balance is:"+balance+"therefore withdrawal of amount:"+amount+"is not allowed");
        }
    }

    void Deposit()
    {
        int amount;
        System.out.println("Enter the amount to be deposited");
        amount=sc.nextInt();
        balance=balance+amount;

    }

    void show()
    {
        System.out.println("Account number:"+accno+"-----"+"having balance"+balance);
    }


    public static void main(String[] args) {
        System.out.println("Program started");
        BankAccount b1=new BankAccount(2342,6000.00);
        try {
            b1.withdraw();
        }
        catch(Exception e)
        {
            System.out.println(e);
            System.out.println("balance amount is less than the withdrawal amount. Please enter the valid amount that you wanted to withdraw");
        }
        b1.Deposit();
        b1.show();
        System.out.println("Program ended");
        // sc=new Scanner(System.in);
    }
}
