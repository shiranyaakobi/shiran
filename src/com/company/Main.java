package com.company;

public class Main {

    public static void main(String[] args) {
        PremiumAccount pa = new PremiumAccount(1234);
        BasicAccount ba  = new BasicAccount(1235 , 400);
        StandardAccount sa = new StandardAccount(1236,-500);
        pa.Deposit(100);
        ba.Deposit(100);
        sa.Deposit(100);
        System.out.println("Expected 100 actual " + sa.GetCurrentBalance());
        double check1 = sa.Withdraw(605);
        System.out.println("Expected 600 actual " + check1);
        System.out.println("Expected -500 actual " + sa.GetCurrentBalance());
        double check2 = ba.Withdraw(600);
        System.out.println("Expected 100 actual " + check2);

        Bank b = new Bank();
        b.OpenAccount(sa);
        b.OpenAccount(pa);
        b.OpenAccount(ba);
        b.CloseAccount(pa.accountnumber);
        b.CloseAccount(sa.accountNumber);

        b.GetAllAccountsInDebt();
        b.GetAllAccountsWithBalance(-800);

    }
}

