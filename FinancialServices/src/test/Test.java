package test;

import app.App;
import model.Account;
import model.Customer;

import java.util.List;

public class Test {

	public static void main(String Args[]) {

		Test test = new Test();
		test.createData();
		test.process();

	}

	private void createData() {
		Customer customer1 = new Customer(1, "Vali1", "Jaferov1");
		App.getCustomerList().add(customer1);
		Customer customer2 = new Customer(2, "Vali2", "Jaferov2");
		App.getCustomerList().add(customer2);
		Customer customer3 = new Customer(3, "Vali3", "Jaferov3");
		App.getCustomerList().add(customer3);

		Account account1 = new Account(1, "Main Account", 1000);
		App.getAccountList().add(account1);
		List<Account> customer1Accounts = customer1.getAccountList();
		customer1Accounts.add(account1);
		customer1.setAccountList(customer1Accounts);

		Account account2 = new Account(2, "Main Account", 2000);
		App.getAccountList().add(account2);
		List<Account> customer2Accounts = customer2.getAccountList();
		customer2Accounts.add(account2);
		customer2.setAccountList(customer2Accounts);

		Account account3 = new Account(3, "Main Account", 3000);
		App.getAccountList().add(account3);
		List<Account> customer3Accounts = customer3.getAccountList();
		customer3Accounts.add(account3);
		customer3.setAccountList(customer3Accounts);

	}

	private void process() {
		App.getAccountService().sendAndReceive(1, 101, 2);
		App.getAccountService().sendAndReceive(1, 200, 2);
		App.getAccountService().sendAndReceive(2, 50, 1);
		App.getAccountService().accountInformation(1);
		App.getAccountService().accountInformation(2);

	}

}
