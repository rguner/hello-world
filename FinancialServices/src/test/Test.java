package test;

import model.Account;
import model.Customer;
import service.AccountService;
import service.TransactionService;

import java.util.ArrayList;
import java.util.List;

public class Test {

	private static List<Customer> customerList = new ArrayList<>();
	private static List<Account> accountList = new ArrayList<>();

	private static AccountService accountService = new AccountService();
	private static TransactionService transactionService = new TransactionService();

	public static void main(String Args[]) {

		Test test2 = new Test();
		test2.createData();
		test2.process();

	}

	private void createData() {
		Customer customer1 = new Customer(1, "Vali1", "Jaferov1");
		getCustomerList().add(customer1);
		Customer customer2 = new Customer(2, "Vali2", "Jaferov2");
		getCustomerList().add(customer2);
		Customer customer3 = new Customer(3, "Vali3", "Jaferov3");
		getCustomerList().add(customer3);

		Account account1 = new Account(1, "Main Account", 1000);
		getAccountList().add(account1);
		List<Account> customer1Accounts = customer1.getAccountList();
		customer1Accounts.add(account1);
		customer1.setAccountList(customer1Accounts);

		Account account2 = new Account(2, "Main Account", 2000);
		getAccountList().add(account2);
		List<Account> customer2Accounts = customer2.getAccountList();
		customer2Accounts.add(account2);
		customer2.setAccountList(customer2Accounts);

		Account account3 = new Account(3, "Main Account", 3000);
		getAccountList().add(account3);
		List<Account> customer3Accounts = customer3.getAccountList();
		customer3Accounts.add(account3);
		customer3.setAccountList(customer3Accounts);

	}

	private void process() {
		getAccountService().sendAndReceive(1, 101, 2);
		getAccountService().sendAndReceive(1, 200, 2);
		getAccountService().sendAndReceive(2, 50, 1);
		getAccountService().accountInformation(1);
		getAccountService().accountInformation(2);

	}

	public static AccountService getAccountService() {
		return accountService;
	}

	public static void setAccountService(AccountService accountService) {
		Test.accountService = accountService;
	}

	public static List<Customer> getCustomerList() {
		return customerList;
	}

	public static void setCustomerList(List<Customer> customerList) {
		Test.customerList = customerList;
	}

	public static List<Account> getAccountList() {
		return accountList;
	}

	public static void setAccountList(List<Account> accountList) {
		Test.accountList = accountList;
	}

	public static TransactionService getTransactionService() {
		return transactionService;
	}

	public static void setTransactionService(TransactionService transactionService) {
		Test.transactionService = transactionService;
	}
}
