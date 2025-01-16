package com.viwe;

import java.sql.SQLException;
import java.util.Scanner;

import com.controller.BankController;

public class Bankview {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);

		BankController b = new BankController();
		BankController.Connection();

		while (true) {

			while (true) {

				System.out.println("\t **** welcome to skills it  bank ****");

				System.out.println("\t 1: Add Account  ");
				System.out.println("\t 2: viwe account");
				System.out.println("\t 3: serch account by account number");
				System.out.println("\t 4: deposit ");
				System.out.println("\t 5: withdrow");
				System.out.println("\t 6: cheak balence");
				System.out.println("\t 7: exit \n ");
				System.out.println(
						"----------------------------------------------------------------------------------------------------------");

				System.out.println("enter your choice ");
				int choice = sc.nextInt();

				switch (choice) {

				case 1:
					b.addAccount();
					break;

				case 2:
					b.viweAccount();
					break;

				case 3:
					b.serchaccountbyaccountnumber();
					break;

				case 4:
					b.deposit();
					break;

				case 5:
					b.withdrow();
					break;

				case 6:
					b.cheakbalence();
					break;
				}
			}

		}

	}

}
