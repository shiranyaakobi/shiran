package com.company;

import java.util.ArrayList;
import java.util.List;

public class Bank implements IBank{
	protected List <IAccount> accounts;
	public Bank () {
		accounts = new ArrayList<IAccount>();
	}
	@Override
	public void OpenAccount(IAccount account) {
		int accountNumber = account.GetAccountNumber();

		for(IAccount existingAccount : accounts){
			if(existingAccount.GetAccountNumber() == accountNumber){
				System.out.println("Account already exists!");
				return;
			}
		}

		accounts.add(account);
	}

	@Override
	public void CloseAccount(int accountnumber) {
		int i;
		IAccount temp;
		for (i=0; i< accounts.size(); i++) {
			temp = accounts.get(i);
			if (temp.GetAccountNumber() == accountnumber) {
				if (temp.GetCurrentBalance()<0)
					System.out.println("Sorry , you cant close your account while you in debt");
				else
				{
					accounts.remove(i);
					System.out.println("we succesfully removed you from the bank");
				}
			}
		}
		
	}

	@Override
	public List<IAccount> getAllAccounts() {
		return accounts;
	}

	@Override
	public List<IAccount> GetAllAccountsInDebt() {
		List <IAccount> lstDebt = new ArrayList<IAccount>();
		int i;
		for (i=0; i< accounts.size(); i++) {
			if (accounts.get(i).GetCurrentBalance() < 0 ) {
				lstDebt.add(accounts.get(i));
			}
		}
		return lstDebt;
	}

	@Override
	public List<IAccount> GetAllAccountsWithBalance(double balanceabove) {
		List <IAccount> lstBigger = new ArrayList<IAccount>();
		int i;
		for (i=0; i< accounts.size(); i++) {
			if (accounts.get(i).GetCurrentBalance()>balanceabove)
				lstBigger.add(accounts.get(i));
		}
		return lstBigger;

	}

}
