package org.finance.accounts;
import java.math.BigDecimal;


public class Savings extends Account{

	protected BigDecimal interest;

	public Savings(String iname,String iaccountid, BigDecimal iStartingBalance, BigDecimal uinterest ){
		super(iname, iaccountid, iStartingBalance);
		interest = uinterest;
}

	public Savings(){
		super();
		interest = new BigDecimal(0.3);
	}
	
	public String toString(){
		String s;
		s = "number: " + accountId +", " + "name: " + name+"\n" +
		"starting balance: $"+ startingBalance +", " + "current balance: $"+ balance +"\n"+
		"type: SAVINGS\n" +
		"annual interest rate: "+ interest.doubleValue() + "%\n\n";
		return s;
	}

	//Equals method only checks on accountID cause of they way I used it in code in previous versions
	public boolean equals( Object z ) {

		boolean result = false;

		if ( z instanceof Account ) {

			Account z2 = (Account) z;

			if (
			     (z2.accountId.equals(accountId)))

			     result = true;
		}

		return result;
	}
	
}