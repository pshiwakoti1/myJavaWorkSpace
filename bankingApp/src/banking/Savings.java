package banking;

public class Savings extends Account{

	private double balance;
	
	
	@Override
	public double deposit(double amount,String userId) {
		
		return balance + amount;
	}

	@Override
	public double withdraw(double amount,String userId) {
		
		return balance - amount;
	}

}
