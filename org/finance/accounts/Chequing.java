package org.finance.accounts;
import java.math.BigDecimal;
import java.util.*;

public class Chequing extends Account{
	protected BigDecimal service;
    protected ArrayList<BigDecimal> trans;
    protected BigDecimal totalCharges;
    
    public Chequing(String iname,String iaccountid, BigDecimal iStartingBalance, BigDecimal uservice ){
        super(iname, iaccountid, iStartingBalance);
        service = uservice;
        trans = new ArrayList<BigDecimal>();
        totalCharges = new BigDecimal(0);
    }

    public Chequing(){
        super();
        service = new BigDecimal(0.25);
        trans = new ArrayList<BigDecimal>();
    }

    //Subtracts amount to balance
    public boolean deposit (BigDecimal amount){
        if(amount.compareTo(new BigDecimal(0) )<0){
            return false;
        }else if(balance.add(amount).compareTo(new BigDecimal (0)) <0){
            return false;
        }
        balance = balance.add(amount);
        trans.add(amount);
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
        trans.add(amount.multiply (new BigDecimal(-1)));
        totalCharges = totalCharges.add(service);
        return true;


    }

    public String toString(){
        String s;
        s = "number: " + accountId +", " + "name: " + name+"\n" +
                "starting balance: $"+ startingBalance +", " + "current balance: $"+ balance +"\n"+
                "type: Chequing\n" +
                "service charge: $" + service +"\n"+
                "number of transactions: " + trans.size() + "\n" +
                "total amount of service charge: $"+totalCharges+"\n\n";
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
    
    public BigDecimal getTotalCharge() {
    	return totalCharges;
    }
    
    public ArrayList<BigDecimal> getTrans() {
    	return trans;
    }

    
   
}