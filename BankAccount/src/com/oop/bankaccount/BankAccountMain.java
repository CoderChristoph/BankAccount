package com.oop.bankaccount;

public class BankAccountMain {

	public static void main(String[] args) {
		BankAccount person1 = new BankAccount();

//		person1.deposit(100, false, true);
//		person1.deposit(1500, true, false);
		person1.deposit(1000, true, true);
		
		person1.getAllAccountInfo();
	}

}
