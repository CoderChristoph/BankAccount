package com.oop.bankaccount;

import java.util.HashMap;
import java.util.Random;
import java.util.Set;

public class BankAccount {
	private String accountNumber;
	private double checkings;
	private double savings;
	private static int numberOfAccounts = 0;
	private static double totalAmount = 0.0;
	
	private String accountNumber() {
		Random rand = new Random();
		String an = " ";
		for (int i = 0; i < 10; i++) {
			int num = rand.nextInt(9);
			an += num;
		}
		return an;
	}
	
	public BankAccount() {
		this.accountNumber = this.accountNumber();
		numberOfAccounts++;
	}
	
	public double getChecking() {
		return this.checkings;
	}
	
	public double getSavings() {
		return this.savings;
	}
	
	public void getAllAccountInfo() {
		HashMap<String, String> account = new HashMap<String, String>();
		String an = "Account Number";
		String check = " ";
		check += this.checkings;
		String checking = "Checkings";
		String save = " ";
		String savings = "Savings";
		save += this.savings;
		String total = " ";
		total += totalAmount;
		account.put(an, this.accountNumber);
		account.put(checking, check);
		account.put(savings, save);
		Set<String> newSet = account.keySet();
		for (String keys : newSet) {
			System.out.println("Your " + keys + " : " + account.get(keys));
		}
	}
	
	public void deposit(double money, boolean savings, boolean checkings) {
		if (savings == true && checkings == false) {
			System.out.println("You have successfully deposited " + money + " into your savings account!");
			this.savings += money;
			totalAmount += money;
		} else if (checkings == true && savings == false) {
			this.checkings += money;
			totalAmount += money;
			System.out.println("You have successfully deposited " + money + " into your checkings account");
		} else if(checkings == true && savings == true) {
			this.savings += money / 2;
			this.checkings += money / 2;
			totalAmount += money;
			System.out.println("Since you selected both your checkings and savings, your money has been split and half deposited into savings and the other half into checkings!");
        } else {
            System.out.println("You failed to select an account. No money has been deposited");
        }
	}
	
	public double withdraw(double money, boolean savings) {
		if (savings == true) {
			if (this.savings >= money) {
				this.savings -= money;
				totalAmount -= money;
				return money;
			} else {
				System.out.println("you have insufficient funds!");
			}
		} else {
			if (this.checkings >= money) {
				this.checkings -= money;
				totalAmount -= money;
				return money;
			} else {
				System.out.println("you have insufficient funds!");
			}
		}
		return 0.0;
	}
	
	public static double total() {
		return totalAmount;
	}
}
