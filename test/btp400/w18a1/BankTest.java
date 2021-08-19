package test.btp400.w18a1;
//Authors: Al Vincent Valdez collaborated with Carlianz Pura
//Student Number: 109114165
//Using Junit 3
import java.math.BigDecimal;

import org.finance.accounts.Chequing;
import org.finance.accounts.GIC;
import org.finance.accounts.Savings;

import com.little.bank.Bank;

import junit.framework.TestCase;

public class BankTest extends TestCase {

protected Chequing a1, a2, a1copy, a3;

	
	Bank alvin = new Bank("Alvin");
	Bank alvincopy = new Bank("Alvin");
	protected void setUp() throws Exception {
		super.setUp();
		
		a1 = new Chequing("Alvin Valdez", "A6969", new BigDecimal(999.00),new BigDecimal(0.75));
		a2 = new Chequing("Alvin Valdez", "A9696",new BigDecimal(999.00),new BigDecimal(0.75));
		a3 = new Chequing();
		
		
		
		alvin.addAccount(a1);
		alvin.addAccount(a2);
		alvin.addAccount(a3);
		
		alvincopy.addAccount(a1);
		alvincopy.addAccount(a2);
		alvincopy.addAccount(a3);
	}
	
	public void testBankLength() {
		assertEquals(alvin.getBankArray().size(),3);
	}

	
	public void testAddChequing() {
		Chequing temp = new Chequing("Alvin Valdez", "A5678", new BigDecimal(999.00),new BigDecimal(0.75));
		alvin.addAccount(temp);
		assertEquals(alvin.getBankArray().size(), 4);
	}
	
	public void testAddSavings() {
		Savings temp = new Savings("Alvin Valdez", "A5678", new BigDecimal(999.00),new BigDecimal(0.75));
		alvin.addAccount(temp);
		assertEquals(alvin.getBankArray().size(), 4);
	}
	
	
	public void testAddGIC() {
		GIC temp = new GIC("Alvin Valdez", "A5678", new BigDecimal(999.00),5,new BigDecimal(0.75));
		alvin.addAccount(temp);
		assertEquals(alvin.getBankArray().size(), 4);
	}

	public void testToString() {
		String s =

                "*** Welcome to the bank of "+"Alvin"+" ***\n"+
                        "It has "+"3"+" accounts.\n\n";

        assertEquals(alvin.toString(),s);
	}

	
	public void testSearchByBalance() {
		assertEquals(alvin.searchByBalance(new BigDecimal(999)).length,2);
	}
	
	public void testSearchByBalanceNegative() {
		assertEquals(alvin.searchByBalance(new BigDecimal(-1)).length,0);
	}


	public void testSearchByAccountName() {
		assertEquals(alvin.searchByAccountName("Alvin Valdez").length, 2);
	}
	
	public void testSearchByAccountNameBlank() {
		assertEquals(alvin.searchByAccountName("").length, 0);
	}
	
	public void testSearchByAccountNameFail() {
		assertEquals(alvin.searchByAccountName("bob").length, 0);
	}
	
	

	public void testSearchByAccountNumber() {
		assertEquals(alvin.searchByAccountNumber("A6969"),alvin.getBankArray().get(0));
	}
	
	public void testSearchByAccountNumberBlank() {
		assertEquals(alvin.searchByAccountNumber(""),null);
	}
	
	
	
	public void testSearchByAccountNumberFail() {
		assertEquals(alvin.searchByAccountNumber("90"),null);
	}


	public void testRemoveAccount() {
		alvin.removeAccount("A6969");
		assertEquals(2,alvin.getBankArray().size());
	}
	
	public void testRemoveAccountBlank() {
		alvin.removeAccount("");
		assertEquals(3,alvin.getBankArray().size());
	}
	
	public void testRemoveAccountInvalid() {
		alvin.removeAccount("90");
		assertEquals(3,alvin.getBankArray().size());
	}

}
