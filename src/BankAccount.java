
import java.util.Scanner;

public class BankAccount
{
//static variable shares the same value throughout the program
static double accountBalance;
double newAccountBalance;
    // to withdraw funds from the account
    public synchronized void withdraw(double amount)  
    {
        //variable declaration
        if(amount>accountBalance)
        {
             //there are not enough funds in the account
        System.out.println("Do not have sufficent amount in your account"); 
        }
        else
        {
        //update the new account balance
            newAccountBalance=accountBalance-amount;
            accountBalance = newAccountBalance;
            System.out.println(amount+" amount was withdrawn from your account sucessfully.");
            System.out.println("Your Account Balance: "+newAccountBalance);
        }
    }
    //to deposit the amount in the account
    public synchronized void deposit(double amount) 
    {
    if(amount<0.0) //checks for negative values
    {
    System.out.println("Can not depoist negative amount"); // can not deposit a negative amount
    }
    else
    {
    //update the new account balance
          newAccountBalance = accountBalance+amount;
          accountBalance = newAccountBalance;
          System.out.println("Your amount "+amount+" is sucessfully deposited.");
          System.out.println("Your Account Balance: "+newAccountBalance);
         }
     }
    
    public static void main(String[]args)
    {
    BankAccount obj= new BankAccount(); //creating object for the account class
    Scanner scan= new Scanner(System.in);
    //loop until user quits
    do
    {
    System.out.println("\nChoose Your choice:");
        System.out.println("1.Deposit");
        System.out.println("2.Withdraw");
        System.out.println("3.Press 'q' to quit");
       
        switch(scan.next().charAt(0))
        {
        case '1': System.out.println("Enter amount to be deposited");
         double amount=scan.nextDouble(); //accepting amount to be deposited
         obj.deposit(amount);//calling deposite method
         main(args);break;
        case '2': System.out.println("Enter amount to withdraw");
         double withDrawAmount=scan.nextDouble();//accepting amount to withdraw
obj.withdraw(withDrawAmount); //calling withdraw method
main(args);break;
//quits the program it user press q letter
        case 'q': System.out.println("Thank you for quitting.");System.exit(0);
        }
    }
    while(scan.next().charAt(0)=='q'||scan.next().charAt(0)=='Q');
    //quits the program it user press q letter

    }
}
