package com.model;

public class Bank {
	private int accno;
	private String name;
	private double balence;

	public Bank() {

		this.accno = accno;
		this.name = name;
		this.balence = balence;

	}

	public void deposite(double ammount) {
		if (ammount > 0) {
			balence = balence + ammount;
			System.out.println(ammount + " credited your account " + accno + " sussesfully!!!");
			System.out.println("after deposite your current balence is " + balence);

		} else
			System.out.println("negitive ammount can not be deposited");

	}

	public void withdrow(double ammount) {
		if (ammount < balence) {
			balence = balence - ammount;
			System.out.println(ammount + " withdrow from  your account " + accno + "sussesfully!!!");
			System.out.println("after withdrow  your current balence is " + balence);
		} else
			System.out.println("insufficient balence !!!");

	}

	public void cheakbalence() {
		System.out.println("your current balence is :" + balence);
	}

	public int getAccountnumber() {
		return accno;
	}

	public String getName() {
		return name;
	}

	public double getBalence() {
		return balence;
	}

	public void setAccountnumber(int accountnumber) {
		accno = accountnumber;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBalence(double balence) {
		this.balence = balence;
	}

	public String toString() {
		return "BankAccount [Accountnumber=" + accno + ", name=" + name + ", balence=" + balence + "]";
	}

}



