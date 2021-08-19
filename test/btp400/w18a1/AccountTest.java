package test.btp400.w18a1;
//Author: Al Vincent Valdez
//Student Number: 109114165
//Using Junit 3

import java.math.BigDecimal;

import org.finance.accounts.Account;

import junit.framework.TestCase;

public class AccountTest extends TestCase {

	protected Account a1, a2, a1copy, a3;
	
protected void setUp() throws Exception {
		super.setUp();
		
		a1 = new Account("Alvin Valdez", "A6969", new BigDecimal(999.00));
		a1copy = new Account("Alvin Valdez", "A6969",new BigDecimal(999.00));
		a2 = new Account();
		a3 = new Account();
	}
	
	public void testEquals() {
		assertEquals(a1.equals(a1copy),true);
	}


	public void testToString() {
		String s =  "number: A6969, name: Alvin Valdez\n"+
				"starting balance: $999, current balance: $999\n\n";

	assertEquals(s, a1.toString());
	}

	public void testSetFullName() {
		a1.setFullName("Bobby Drake");
		assertEquals("Bobby Drake",a1.getFullName());
	}
	
	public void testSetFullNameBlank() {
		a1.setFullName("");
		assertEquals("",a1.getFullName());
	}
	
	public void testSetFullNameNull() {
		a1.setFullName(null);
		assertEquals("",a1.getFullName());
	}

	public void testSetAccountNumber() {
		a1.setAccountNumber("A9696");
		assertEquals(a1.getAccountNumber(),"A9696");
	}
	
	public void testSetAccountNumberBlank() {
		a1.setAccountNumber("");
		assertEquals(a1.getAccountNumber(),"");
	}
	
	public void testSetAccountNumberNull() {
		a1.setAccountNumber(null);
		assertEquals(a1.getAccountNumber(),"");
	}

	public void testSetAccountBalance() {
		a1.setAccountBalance(new BigDecimal(6969.00));
		assertEquals(new BigDecimal(6969.00),a1.getAccountBalance());
	}
	public void testSetAccountBalanceNegative() {
		a1.setAccountBalance(new BigDecimal(-1));
		assertEquals(new BigDecimal(0),a1.getAccountBalance());
	}
	
	

	public void testGetFullName() {
		assertEquals(a1.getFullName(),"Alvin Valdez");
	}

	public void testGetAccountNumber() {
		assertEquals(a1.getAccountNumber(),"A6969");
	}

	public void testGetAccountBalance() {
		assertEquals(new BigDecimal(999.00),a1.getAccountBalance());
	}

	public void testDeposit() {
		a1.deposit(new BigDecimal(1));
		assertEquals(a1.getAccountBalance(),new BigDecimal(1000.00));
	}

	public void testWithdraw() {
		a1.withdraw(new BigDecimal(100.00));
		assertEquals(a1.getAccountBalance(),new BigDecimal(899.00));

	}
	
	public void testWithdrawNegative() {
		a1.withdraw(new BigDecimal(-1));
		assertEquals(new BigDecimal(999.00), a1.getAccountBalance());
	}
	
	public void testWithdrawOverdraw() {
		a1.withdraw(new BigDecimal(1000));
		assertEquals(new BigDecimal(999.00), a1.getAccountBalance());
	}
	
	public void testDepositNegative() {
		a1.deposit(new BigDecimal(-1));
		assertEquals(new BigDecimal(999.00), a1.getAccountBalance());
	}
	
}