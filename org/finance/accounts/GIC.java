package org.finance.accounts;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class GIC extends Account {
    protected int investyears;
    protected BigDecimal interestrate;

    public GIC(String iname, String iaccountid, BigDecimal iStartingBalance, int years, BigDecimal uinterestrate) {
        super(iname, iaccountid, iStartingBalance);
        interestrate = uinterestrate;
        investyears = years;
    }

    public GIC() {
        super();
        investyears = 1;
        interestrate = new BigDecimal(1.25);
    }

  //Adds amount to balance GIC can't deposit though
    public boolean deposit(BigDecimal amount) {
        return false;
    }

    //Adds amount to balance GIC can't withdraw though
    public boolean withdraw(BigDecimal amount) {
        return false;
    }

    //gives the balance at maturity before rounding
    public BigDecimal getBalanceAtMaturity() {
      BigDecimal rn = interestrate.add(new BigDecimal(1));
      rn = rn.pow(investyears);
      BigDecimal answer = startingBalance.multiply(rn);
      return answer;

    }

    public String toString(){
        String s = "number: " + accountId +", " + "name: " + name+"\n" +
                "starting balance: $"+ startingBalance +", " + "current balance: $"+ balance +"\n"+
                "type: GIC\n" +
                "annual invest rate: "+ interestrate.doubleValue()+"%\n"+
                "period of investment: "+ investyears +" years\n"+
               "new balance at maturity: $" + getBalanceAtMaturity().setScale(2,RoundingMode.FLOOR)+"\n\n";
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