package org.finance.accounts;
import java.math.BigDecimal;

public class Account {
	protected String name;
	protected String accountId;
	protected BigDecimal balance;
	protected BigDecimal startingBalance; 

	//Default constructor
	public Account(){this(null,null,new BigDecimal(0));};
	
	
	//Constructor with three parameters which are name, accountId and balance
	public Account(String name1, String accountId1, BigDecimal balance1){
		setFullName(name1);
		setAccountNumber(accountId1);
		setAccountBalance(balance1);
		startingBalance = balance1;
	}
	
	//Displays account information of current object
	public String toString(){
		String s;
		
		s = "number: " + accountId +", " + "name: " + name+"\n" +
				"starting balance: $"+ startingBalance +", " + "current balance: $"+ balance +"\n\n";
		
		return s;
	}
	
	//Sets full Name with given parameter also sets name to blank if parameter is null
	public void setFullName(String name1){
		if(name1 == null){
			name = "";
		}else{
			name = name1;
		}
		
		
	}
	
	//Sets account number with given parameter also sets accountId to blank if parameter is null
	public void setAccountNumber(String accountId1){
		if(accountId1 == null){
			accountId = "";
		}else{
			accountId = accountId1;
		}
		
		
	}
	
	//Sets account balance with given parameter also sets balance to 0 if parameter less than 0
	public void setAccountBalance(BigDecimal balance1){
		if(balance1.compareTo (new BigDecimal(0)) < 0){
			balance = new BigDecimal(0);
		}else{
			balance = balance1;
		}
		
		
	}
	
	//Retrieve data inside of name
	public String getFullName(){
		return name;
	}
	
	//Retrieve data inside of accountId
	public String getAccountNumber(){
		return accountId;
	}
	
	//Retrieve data inside of balance
	public BigDecimal getAccountBalance(){
		return balance;
	}


	
	//Subtracts amount to balance
	public boolean deposit (BigDecimal amount){
		if(amount.compareTo(new BigDecimal(0) )<0){
			return false;
		}else if(balance.add(amount).compareTo(new BigDecimal (0)) <0){
			return false;
		}
		balance = balance.add(amount);
		return true;
	}
	
	//Adds amount to balance
	public boolean withdraw (BigDecimal amount){
		if(amount.compareTo(new BigDecimal(0))<0 ){
			return false;
		}else if(balance.subtract(amount).compareTo(new BigDecimal(0))<0){
			return false;
		}
		balance = balance.subtract(amount);
		return true;
		
		
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
	

