package credit_card;

import java.io.PrintStream;

public class CreditCard {
	private CreditCard self = this;
	private static final PrintStream output = new PrintStream( System.out );
	
	// instance variables
	private String number;
	private String name;
	private String bank;
	private double balance;
	private int limit;
	
	// constructor
	CreditCard( String no, String nm, String bk, double bal, int lim ) {
		self.number = no;
		self.name = nm;
		self.bank = bk;
		self.balance = bal;
		self.limit = lim;
	}
	
	// Accessor Methods:
	public String getNumber() {
		return self.number;
	}
	
	public String getName() {
		return self.name;
	}
	
	public String getBank() {
		return self.bank;
	}
	
	public double getBalance() {
		return self.balance;
	}
	
	public int getLimit() {
		return self.limit;
	}
	
	public boolean chargeIt( double price ) { // make a charge
		if ( price + self.balance > (double) limit ) {
			return false;	// There is not enough money left ot charge it
		}
		balance += price;
		return true;	// The charge goes through in this case
	}
	
	public void makePayment( double payment ) { // Make a payment
		balance -= payment;
	}
	
	@Override
	public String toString() {
		return String.format( "%s = %s\n%s = %s\n%s = %s\n%s = %,.2f\n%s = %d\n",
				"Number", self.getNumber(), "Name", self.getName(),
				"Bank", self.getBank(), "Balance", self.getBalance(),
				"Limit", self.getLimit() );
	}
	
	public static void printCard( CreditCard c ) {
		output.println( c.toString() );
	}
}
