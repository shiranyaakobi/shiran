package com.company;

public class BasicAccount implements IAccount {
	protected int accountnumber;
	protected double withdrawLimit;
	protected double currentbalance;
	protected double creditlimit;
	public BasicAccount(int accountnumber, double withdrawLimit) {
		this.accountnumber = accountnumber;
		if(withdrawLimit<0) {
			withdrawLimit=0;
		}
		this.withdrawLimit = withdrawLimit;
		this.currentbalance = 0;
		creditlimit=0;
	}
	@Override
	public void Deposit(double amount) {
		currentbalance +=amount;
		
	}
	@Override
	public double Withdraw(double amount) {
		double actuleAmount = 0.0;
		if(amount > currentbalance || amount > withdrawLimit){
			if(amount > currentbalance && amount <= withdrawLimit){
				actuleAmount = currentbalance;
			}else if(amount <= currentbalance && amount > withdrawLimit){
				actuleAmount = withdrawLimit;
			}else if(amount > currentbalance && amount > withdrawLimit){
				actuleAmount = Math.min(currentbalance, withdrawLimit);
			}
		}else{
			actuleAmount = amount;
		}

		currentbalance -= actuleAmount;

		return actuleAmount;
	}
	@Override
	public double GetCurrentBalance() {
		// TODO Auto-generated method stub
		return currentbalance;
	}
	@Override
	public int GetAccountNumber() {
		// TODO Auto-generated method stub
		return accountnumber;
	}
}
