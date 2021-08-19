package test.btp400.w18a1;
//Authors: Al Vincent Valdez collaborated with Carlianz Pura
//Student Number: 109114165
//Using Junit 3
import junit.framework.TestCase;
import java.math.BigDecimal;

import org.finance.accounts.Savings;
public class SavingsTest extends TestCase {

	protected Savings a1, a2, a1copy, a3;
	
	protected void setUp() throws Exception {
		super.setUp();
		
		a1 = new Savings("Alvin Valdez", "A6969", new BigDecimal(999.00),new BigDecimal(0.5));
		a1copy = new Savings("Alvin Valdez", "A6969",new BigDecimal(999.00),new BigDecimal(0.5));
		a2 = new Savings();
		a3 = new Savings();
	}
	
	public void testEqualsObject() {
		assertEquals(a1.equals(a1copy),true);
	}
	
	

	

}
