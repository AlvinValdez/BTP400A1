package test.btp400.w18a1;
//Authors: Al Vincent Valdez collaborated with Carlianz Pura
//Student Number: 109114165
//Using Junit 3
import junit.framework.TestCase;
import java.math.BigDecimal;

import org.finance.accounts.GIC;

public class GICTest extends TestCase {

	protected GIC a1, a2, a1copy;
	
	protected void setUp() throws Exception {
		super.setUp();
		
		a1 = new GIC("Alvin Valdez", "A9696", new BigDecimal(1000.00), 5, new BigDecimal(0.2));
		a1copy = new GIC("Alvin Valdez", "A9696", new BigDecimal(1000.00), 5, new BigDecimal(0.2));
		a2 = new GIC();
	}
	
	public void testDeposit() {
		a1.deposit(new BigDecimal(500.00));
		assertEquals(a1.getAccountBalance(), new BigDecimal(1000.00));
	}

	public void testWithdraw() {
		a1.withdraw(new BigDecimal(500.00));
		assertEquals(a1.getAccountBalance(), new BigDecimal(1000.00));
	}

	public void testDepositNegative() {
		a1.deposit(new BigDecimal(-1));
		assertEquals(a1.getAccountBalance(), new BigDecimal(1000.00));
	}

	public void testWithdrawNegative() {
		a1.withdraw(new BigDecimal(-1));
		assertEquals(a1.getAccountBalance(), new BigDecimal(1000.00));
	}
	
	public void testDepositZero() {
		a1.deposit(new BigDecimal(0));
		assertEquals(a1.getAccountBalance(), new BigDecimal(1000.00));
	}

	public void testWithdrawZero() {
		a1.withdraw(new BigDecimal(0));
		assertEquals(a1.getAccountBalance(), new BigDecimal(1000.00));
	}
	
	

	
}
