import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class atm_interface {
    private static int userid=4455;
    private static int pin=0213;
    private static double bal=100000.00;
    private static Scanner s=new Scanner(System.in);
    private static String transaction;
    private static List<String>transactionHistory=new ArrayList<>();
    public static void main(String[] args) {
        System.out.println("*****WELCOME TO THE ATM*****");
        int euserid,epin;  
        System.out.println("enter the userid:");
        euserid=s.nextInt();
        System.err.println("enter the pin:");
        epin=s.nextInt();
        if(euserid!=userid&&epin!=pin)
        {
            System.out.println("incorrect userid or pin...");
        }
        else
        {
            System.out.println("login successfull...");
            menu();
        }
    }
    public static void menu()
    {
        while(true)
        {
            System.out.println("-*-*-*-*-*-*-*ATM-*-*-*-*-*-*-*");
            System.out.println("1.transaction history");
            System.out.println("2.withdraw");
            System.out.println("3.deposit");
            System.out.println("4.transfer");
            System.out.println("5.quit");
            System.out.println("enter your choice:");
            int ch=s.nextInt();
            switch (ch) 
            {
                case 1:
                    transactionhistory();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    deposit();
                    break;
                case 4:
                    transfer();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("it is an invalid choice please try again.....");
            }
        }
    }
    public static void transactionhistory()
    {
        System.out.println("transaction history are:");
        if(transactionHistory.isEmpty())
        {
            System.out.println("transaction are not done yet...");
        }
        else
        {
            int i;
            for(i=0;i<transactionHistory.size();i++)
            {
                transaction=transactionHistory.get(i);
                System.out.println(transaction);
            }
        }
    }
    public static void withdraw()
    {
        System.out.println("enter the amount to withdraw:");
        double amt=s.nextDouble();
        if(amt>bal)
        {
            System.out.println("insufficient balance...");
        }
        else
        {
            bal=bal-amt;
            transaction="withdraw amount:"+amt+"  current balance:"+bal;
            transactionHistory.add(transaction);
            System.out.println("withdrawal successfull...");
            System.out.println("remaining balance is:"+bal);
        }
    }
    public static void deposit()
    {
        System.out.println("enter the deposit amount:");
        double amt=s.nextDouble();
        bal=bal+amt;
        transaction="deposit amount:"+amt+"  current balance:"+bal;
        transactionHistory.add(transaction);
        System.out.println("your deposit is successfull...");
        System.out.println("remaining balance is:"+bal);
    }
    public static void transfer()
    {
        System.out.println("enter the amount to transfer:");
        double amt=s.nextDouble();
        if(amt>bal)
        {
            System.out.println("insufficient balance...");
        }
        else
        {
            System.out.println("enter the account no. to transfer:");
            int pid=s.nextInt();
            bal=bal-amt;
            transaction="transfer amount:"+amt+"  and transfered account number is:"+pid+"  current balance:"+bal;
            transactionHistory.add(transaction);
            System.out.println("transfer amount is successfull...");
            System.out.println("reamaining balance is:"+bal);
        }
    }
}
