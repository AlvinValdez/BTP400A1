package test.btp400.w18a1;
//Authors: Al Vincent Valdez collaborated with Carlianz Pura
//Student Number: 109114165
//Using Junit 3
import java.math.BigDecimal;

import org.finance.accounts.Chequing;

import junit.framework.TestCase;

public class ChequingTest extends TestCase {

protected Chequing a1, a2, a1copy, a3;
	
	protected void setUp() throws Exception {
		super.setUp();
		
		a1 = new Chequing("Alvin Valdez", "A6969", new BigDecimal(999.00),new BigDecimal(0.75));
		a1copy = new Chequing("Alvin Valdez", "A6969",new BigDecimal(999.00),new BigDecimal(0.75));
		a2 = new Chequing();
		a3 = new Chequing();
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


	public void testEqualsObject() {
		assertEquals(a1.equals(a1copy),true);
	}
	
	public void testArrayOfTransUpdatingWithdraw() {
		a1.withdraw(new BigDecimal(100.00));
		assertEquals(a1.getTrans().size(),1);
	}
	
	public void testArrayOfTransUpdatingDeposting() {
		a1.deposit(new BigDecimal(100.00));
		assertEquals(a1.getTrans().size(),1);
	}
	
	public void testArrayTransCost() {
		a1.withdraw(new BigDecimal(100.00));
		assertEquals(a1.getTotalCharge(),new BigDecimal(0.75));
	}

	
}
