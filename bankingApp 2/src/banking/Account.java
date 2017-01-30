/*@author: Prakash Shiwakoti
 * San Francisco
 * app: banking online
 * 
 */
package banking;

public abstract class Account {
    
	private int accountNumber;
	
    abstract public double deposit(double amount, String userId);
	abstract public double withdraw(double amount, String userId);
	
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
		
	

}
