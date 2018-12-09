package service;

import app.App;
import model.Account;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

public class AccountService {

	private void receive(Integer accountId, double amount, Integer from, String phrase) {
		Account account = getAccountById(accountId);
		if (phrase.equals("Received") && amount > 0) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			account.setBalance(account.getBalance() + amount);
			App.getTransactionService().addTransactions(account, amount, dtf.format(now) + " Received: " + Double.toString(amount) + " EUR from " + from);
		}
	}

	private void send(Integer accountId, double amount, Integer to, String phrase) {
		Account account = getAccountById(accountId);
		if (phrase.equals("Sent") && amount > 0) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			account.setBalance(account.getBalance() - amount);
			App.getTransactionService().addTransactions(account, amount, dtf.format(now) + " Sent: " + Double.toString(amount) + " EUR to " + to);
		}
	}

	public void sendAndReceive(Integer fromAccountId, double amount, Integer toAccountId) {
		send(fromAccountId, amount, toAccountId, "Sent");
		receive(toAccountId, amount, fromAccountId, "Received");
	}

	public Account getAccountById(Integer accountId) {
		List<Account> accountList = App.getAccountList();
		Optional<Account> optional = accountList.stream().filter(a -> a.getAccountId() == accountId).findAny();
		return optional.get();
	}

	public void accountInformation(Integer accountId) {
		System.out.println("Account : " + getAccountById(accountId));
	}

}
