package banking;

public class Checking extends Account{

	private double balance;
	
	
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public double deposit(double amount,String userId) {
		CheckingDao dao = new CheckingDao();
		return dao.deposit(amount,userId);
	}

	@Override
	public double withdraw(double amount,String userId) {
		CheckingDao dao = new CheckingDao();
		return dao.withdraw(amount, userId);
	}

}
