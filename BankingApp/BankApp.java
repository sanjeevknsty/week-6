import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

abstract class Bank{

    String bankName;
    String branchName;
    static final String BANK_CODE_PREFIX  = "BANK-";
    static int count = 0;
    List<Account> accounts = new ArrayList<>();
    public Bank(String bankName, String branchName){
        this.bankName = bankName;
        this.branchName = branchName;
    }

    abstract void openAccount(Account account);
    abstract void displayBankInfo();
    public String generateBankCode(){
        count++;
        return BANK_CODE_PREFIX+count;
    }
        void getAccountDetails(){
        System.out.println("Account Details ");
        for(Account a: accounts){
            System.out.println(" -------- ");
            System.out.println("Account Type  : "+a.getClass().getSimpleName() + "\nAccount Number : "+a.accountNumber + "\nBalance : "+a.balance + "\nHolder Name : "+a.holderName);
        }
    }
    public Account getAccount(String accountNumber) {
        for (Account acc : accounts) {
            if (acc.accountNumber.equals(accountNumber)) {
                return acc;
            }
        }
        return null;
    }

    @Override
    public String toString(){
        return "Bank Name :" + this.bankName + "\nBranch :" + this.branchName + "\nBankCode: " + this.generateBankCode();
    }

}
abstract class Account {

    String accountNumber;
    double balance;
    String holderName;

    public Account(String accountNumber, double balance, String holderName){
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.holderName = holderName;
    }
    abstract void showAccountType();


}

class NationalizedBank extends Bank{

    List<Account> NationalizedBankAccounts = new ArrayList<>();
    NationalizedBank(String bankName, String branchName){
        super(bankName, branchName);
    }


    @Override
    void openAccount(Account account){
        NationalizedBankAccounts.add(account);
        accounts.add(account);
    }

    @Override
    void displayBankInfo(){
        System.out.println("Bank Name :" + this.bankName + "\nBranch :" + this.branchName + "\nBankCode: " + this.generateBankCode());
    }


}

class CooperativeBank extends Bank {
    List<Account> CooperativeBankAccounts = new ArrayList<>();

    CooperativeBank(String bankName, String branchName){
        super(bankName, branchName);
    }


    @Override
    void openAccount(Account account){
        CooperativeBankAccounts.add(account);
        accounts.add(account);
    }

    @Override
    void displayBankInfo(){

    }
}

interface AccountOperations{
    void deposit(double amount);
    void withdraw(double amount);
    Double getBalance();
}


class SavingsAccount extends Account implements AccountOperations{


    String accountNumber;
    double balance;
    String holderName;


    public SavingsAccount(String accountNumber, double balance, String holderName){
        super(accountNumber, balance, holderName);
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.holderName = holderName;
    }

    void showAccountType(){
        System.out.println("Account Type: "+this.getClass().getSimpleName());
    }

    @Override
    public void deposit(double amount){
        this.balance += amount;

    }

    @Override
    public void withdraw(double amount){
        if(this.balance > 0 && this.balance >= amount){
            this.balance -= amount;
            System.out.println("WithDraw Success");
        }else {
            System.out.println("Insufficient Balance");
        }
    }

    @Override
    public Double getBalance(){
        return this.balance;
    }
}
class CurrentAccount extends Account implements AccountOperations{

    String accountNumber;
    double balance;
    String holderName;


    public CurrentAccount(String accountNumber, double balance, String holderName){
        super(accountNumber, balance, holderName);
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.holderName = holderName;
    }

  @Override
    void showAccountType(){
        System.out.println("Account Type: "+this.getClass().getSimpleName());
    }
    @Override
    public void deposit(double amount){
        this.balance += amount;
    }

    @Override
    public void withdraw(double amount){
        if(this.balance > 0 && this.balance >= amount){
            this.balance -= amount;
            System.out.println("WithDraw Success");
        }else {
            System.out.println("Insufficient Balance");
        }    }

    @Override
    public Double getBalance(){
        return this.balance;
    }
}
class LoanAccount extends Account implements AccountOperations{

    String accountNumber;
    double balance;
    String holderName;


    public LoanAccount(String accountNumber, double balance, String holderName){
        super(accountNumber, balance, holderName);
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.holderName = holderName;
    }


    @Override
    void showAccountType(){
        System.out.println("Account Type: "+this.getClass().getSimpleName());
    }
    @Override
    public void deposit(double amount){
        this.balance += amount;
    }

    @Override
    public void withdraw(double amount){
        if(this.balance > 0 && this.balance >= amount){
            this.balance -= amount;
            System.out.println("WithDraw Success");
        }else {
            System.out.println("Insufficient Balance");
        }
    }

    @Override
    public Double getBalance(){
        return this.balance;
    }
}
public class BankApp {
    CooperativeBank cb = new CooperativeBank("AxisBank","Chennai");
    NationalizedBank nb = new NationalizedBank("StateBank","Nellore");
    public static void main(String[] args) {
        BankApp app = new BankApp();
        Scanner input = new Scanner(System.in);

        System.out.println("1) Open Account");
        System.out.println("2) Deposit Amount");
        System.out.println("3) Withdraw Amount");
        System.out.println("4) Display Account Details");
        System.out.println("5) Exit");
        int openingChoice = input.nextInt();
        switch (openingChoice) {
            case 1:
                app.openAccount(app.cb,app.nb);
                break;
            case 2:
//                depositAmount();
                break;
            case 3:
//                withdrawAmount();
                break;

            case 4:
//                displayAccountDetails();
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid Choice");
                break;
        }




//        NationalizedBank nb = new NationalizedBank("StateBank","Nellore");
//        nb.openAccount(new SavingsAccount("SBIN223",0.23,"Sanjeev"));
//        nb.openAccount(new CurrentAccount("SBIN234",0.23,"Mukesh"));
//        nb.openAccount(new SavingsAccount("SBIN3345",222500.23,"Virat Kohli"));
//        nb.openAccount(new LoanAccount("SBIN654",51200.23,"Rohit"));
//        nb.displayBankInfo();

    }

    public void openAccount(CooperativeBank cb, NationalizedBank nb){
        Scanner input = new Scanner(System.in);
        System.out.println("1) CooperativeBank ");
        System.out.println("2) NationalizedBank ");
        int choice = input.nextInt();
        switch (choice){
            case 1:
                selectAccountType("AXS",cb);
                break;
            case 2:
                selectAccountType("SBIN",nb);
                break;
            default:
                System.out.println("Invalid Choice");
                openAccount(cb, nb);
                break;
        }
    }
    public void selectAccountType(String prefix, Bank bank){
        Scanner input = new Scanner(System.in);
        System.out.println("1) SavingsAccount ");
        System.out.println("2) CurrentAccount ");
        System.out.println("3) LoanAccount ");
        System.out.println("4) All Account Details");
        int inp = input.nextInt();
        System.out.println(bank.getClass().getSimpleName());
        switch (inp){

            case 1:
                bank.openAccount(new SavingsAccount( GenerateAccountNumber(prefix),0.23,inputName()));
                break;
            case 2:
                bank.openAccount(new CurrentAccount( GenerateAccountNumber(prefix),0.23,inputName()));
                break;
            case 3:
                bank.openAccount(new LoanAccount( GenerateAccountNumber(prefix),0.23, inputName()));
                break;
            case 4:
                bank.getAccountDetails();
                break;
            default:
                System.out.println("Invalid Choice");
                selectAccountType(prefix,bank);
                break;
        }
       selectMethods(bank);
    }

    public static String GenerateAccountNumber(String prefix){
        Random  r = new Random();
        String res = prefix +r.nextInt(1000000000);
        System.out.println("Your Account Number is : "+res);
        return res;
    }

    public static String inputName(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Your Name : ");
        String name =  input.next();
        return name;
    }

    public void selectMethods(Bank bank){
        Scanner input = new Scanner(System.in);
        System.out.println("1) Deposit Amount");
        System.out.println("2) Withdraw Amount");
        System.out.println("3) Display Account Details");
        System.out.println("4) Main Menu");
        System.out.println("5) Exit");
        int openingChoice = input.nextInt();
        switch (openingChoice) {
            case 1:
                depositAmount(bank);
                break;
            case 2:
                withdrawAmount(bank);
                break;
            case 3:
                displayAccountDetails(bank);
                break;
            case 4:
                openAccount(cb,nb);
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid Choice");
                break;
        }
        selectMethods(bank);

    }
    public static void depositAmount(Bank bank){
        System.out.println(bank.getClass().getSimpleName());
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Account Number : ");
        String accountNumber = input.next();
        System.out.print("Enter Amount : ");
        double amount = input.nextDouble();
        Account acc = bank.getAccount(accountNumber);
        if(acc instanceof AccountOperations){
            ((AccountOperations) acc).deposit(amount);
            acc.balance = ((AccountOperations) acc).getBalance();
            System.out.println("Balance : "+acc.balance);
        }else {
            System.out.println("Account not found ");
        }

    }

    public static void withdrawAmount(Bank bank){
        System.out.println(bank.getClass().getSimpleName());

        Scanner input = new Scanner(System.in);
        System.out.print("Enter Account Number : ");
        String accountNumber = input.next();
        System.out.print("Enter Amount : ");
        double amount = input.nextDouble();
        Account acc = bank.getAccount(accountNumber);
        if(acc instanceof AccountOperations){
            ((AccountOperations) acc).withdraw(amount);
            acc.balance = ((AccountOperations) acc).getBalance();
            System.out.println("Balance : "+ acc.balance);
        }else {
            System.out.println("Balance InSufficient ");
        }
    }

    public static void displayAccountDetails(Bank bank){
        System.out.println(bank.getClass().getSimpleName());
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Account Number : ");
        String accountNumber = input.next();
        Account acc = bank.getAccount(accountNumber);
        if(acc != null){
            System.out.println("Account Type  : "+acc.getClass().getSimpleName() + "\nAccount Number : "+acc.accountNumber + "\nBalance : "+acc.balance + "\nHolder Name : "+acc.holderName);
        }else {
            System.out.println("Account not found ");
        }
    }

}
