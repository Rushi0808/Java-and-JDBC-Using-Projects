package com.controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.model.Bank;

public class BankController {

	Scanner sc = new Scanner(System.in);

	public static Connection Connection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_management", "root", "0808");
		return con;

	}

	public void addAccount() throws ClassNotFoundException, SQLException {
		Bank bank = new Bank();
		System.out.println("Add Bank Account");
		System.out.println("enter account no ,name, starting balence ");
		bank.setAccountnumber(sc.nextInt());
		bank.setName(sc.next());
		bank.setBalence(sc.nextDouble());

		int accno = bank.getAccountnumber();
		String name = bank.getName();
		double balence = bank.getBalence();
		Statement stm = Connection().createStatement();
		String query = " insert into bank values('" + accno + "','" + name + "','" + balence + "')";
		stm.execute(query);
		System.out.println("Data saved Successfully");
		System.out.println("-------------------------------------------------------------------------");

	}

	public void viweAccount() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_management", "root", "0808");
		CallableStatement cs = con.prepareCall("{call selectData()}");
		ResultSet rs = cs.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getDouble(3));

			System.out.println("-------------------------------------------------");

		}

	}

	public void serchaccountbyaccountnumber() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_management", "root", "0808");
		System.out.println("ENter Account number to be serched  ");
		int Accno = sc.nextInt();
		boolean found = false;
		CallableStatement cs = con.prepareCall("{call selectData()}");
		ResultSet rs = cs.executeQuery();
		while (rs.next()) {
			if (Accno == rs.getInt("ACNo")) {
				found = true;
				 System.out.println(rs.getInt("ACNo"));
				System.out.println(rs.getString("ACName"));
				System.out.println(rs.getDouble("ACBalance"));

				System.out.println("-------------------------------------------------");
				break;
			}
			if  (found){
				System.out.println("Accno not found ");
			}

		} con.close();

	}

	public void deposit() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_management", "root", "0808");
		Scanner sc = new Scanner(System.in);
		Statement stm = con.createStatement();
		System.out.println("Enter Account number to deposit: ");
		int accNo = sc.nextInt();
		CallableStatement cs = con.prepareCall("{call selectData()}");
		ResultSet rs = cs.executeQuery();
		boolean found = false;

		while (rs.next()) {
			if (rs.getInt("ACNo") == accNo) {
				found = true;
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getDouble(3));

				System.out.println("-------------------------------------------------");

				System.out.println("Enter amount to deposit: ");
				int amount = sc.nextInt();

				if (amount < 0) {
					System.out.println("Amount should be greater than zero!!");
					break;
				} else {

					amount += rs.getInt("ACBalance");
					// amount=amount+rs.getDouble(accNo);

					String query = "update bank set ACBalance='" + amount + "' where ACNo='" + accNo + "' ";
					stm.executeUpdate(query);
					System.out.println("Deposited Successfully");
				}
			}

		}

		if (!found) {
			System.out.println("Account number not found.");
		}

		rs.close();
		cs.close();
		con.close();
	}

	public void withdrow() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_management", "root", "0808");
		Scanner sc = new Scanner(System.in);
		Statement stm = con.createStatement();
		System.out.println("Enter Account number to withdrow: ");
		int accNo = sc.nextInt();
		CallableStatement cs = con.prepareCall("{call selectData()}");
		ResultSet rs = cs.executeQuery();
		boolean found = false;

		while (rs.next()) {
			if (rs.getInt("ACNo") == accNo) {
				found = true;
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getDouble(3));

				System.out.println("-------------------------------------------------");

				System.out.println("Enter amount to withdrow: ");
				int amount = sc.nextInt();

				if (amount < 0) {
					System.out.println("Amount should be greater than zero!!");
					break;
				} else {

					amount -= rs.getInt("ACBalance");
					// amount=amount+rs.getDouble(accNo);

					String query = "update bank set ACBalance='" + amount + "' where ACNo='" + accNo + "' ";
					stm.executeUpdate(query);
					System.out.println("withdrow Successfully");
				}
			}

		}

		if (!found) {
			System.out.println("Account number not found.");
		}

		rs.close();
		cs.close();
		con.close();
	}

	public void cheakbalence() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_management", "root", "0808");
		System.out.println("Enter Account number to check balance: ");
		int accNo = sc.nextInt();

		CallableStatement cs = con.prepareCall("{call selectData()}");
		ResultSet rs = cs.executeQuery();

		boolean found = false;

		while (rs.next()) {
			if (rs.getInt("ACNo") == accNo) {
				found = true;
				System.out.println("Account Number: " + rs.getInt("ACNo"));
				System.out.println("Account Name: " + rs.getString("ACName"));
				System.out.println("Current Balance: " + rs.getDouble("ACBalance"));
				System.out.println("-------------------------------------------------");
			}
		}

		if (!found) {
			System.out.println("Account number not found.");
		}

		rs.close();
		cs.close();
		con.close();
	}

}
