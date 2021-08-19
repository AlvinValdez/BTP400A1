package com.little.bank;
import java.math.BigDecimal;
import java.util.*;

import org.finance.accounts.Account;

public class Bank {

    private String bankname;
    private ArrayList<Account> bankArray;

    //No parameter constructor
    public Bank(){
        bankname = "Seneca@York";
        bankArray = new ArrayList<Account>();
    }

    //Constructor with a string parameter
    public Bank(String bname){
        bankname = bname;
        bankArray = new ArrayList<Account>();
    }

    //Adds account to arraylist only unique accounts are allowed
    public boolean addAccount(Account newAccount){

        if(newAccount == null){
            return false;
        }


        for(int i=0; i<bankArray.size();i++){

            if (bankArray.get(i).getAccountNumber().equals(newAccount.getAccountNumber())){
                return false;
            }
        }
        bankArray.add(newAccount);
        return true;
    }

    public String toString(){
        String s =

                "*** Welcome to the bank of "+bankname+" ***\n"+
                        "It has "+bankArray.size()+" accounts.\n\n";

        return s;
    }

    //Compares bank objects based on bankArray and bank name
    public boolean equals(Object z){
        boolean result = false;



        if ( z instanceof Account ) {

            Bank z2 = (Bank) z;



            if ((z2.bankname.equals(bankname)) && z2.bankArray.equals(bankArray)){
                result = true;
            }


        }

        return result;
    }

    //Find accounts by balance returns an array of the accounts found
    public Account[] searchByBalance(BigDecimal bal) {

        Account[] accountArray;
        int counter2 = 0;

        if(bal.compareTo(new BigDecimal(0)) < 0){
            Account[] accountArrayBlank = new Account[0];
            return accountArrayBlank;
        }


        for(int counter = 0; counter < bankArray.size(); counter++){

            if(bankArray.get(counter).getAccountBalance().equals(bal)){
                counter2++;
            }

        }


        accountArray = new Account[counter2];
        counter2 = 0;

        for(int counter = 0; counter < bankArray.size();counter++){

            if(bankArray.get(counter).getAccountBalance().equals( bal)){

                accountArray[counter2] = bankArray.get(counter);
                counter2++;

            }

        }
        if(accountArray.length == 0){

            return accountArray;
        }

        return accountArray;
    }

    public ArrayList<Account> getBankArray(){
        return bankArray;
    }

    public Account[] searchByAccountName(String accountName){
        Account[] accountArray;
        int counter2 = 0;

        if(accountName.equals("")){
            Account[] accountArrayBlank = new Account[0];
            return accountArrayBlank;
        }
        


        for(int counter = 0; counter < bankArray.size(); counter++){

            if(bankArray.get(counter).getFullName().equals(accountName)){
                counter2++;
            }

        }


        accountArray = new Account[counter2];
        counter2 = 0;

        for(int counter = 0; counter < bankArray.size();counter++){

            if(bankArray.get(counter).getFullName().equals( accountName)){

                accountArray[counter2] = bankArray.get(counter);
                counter2++;

            }

        }
        if(accountArray.length == 0){

            return accountArray;
        }

        return accountArray;
    }



    public Account searchByAccountNumber(String accountNumber){
        if(accountNumber.equals(null) || accountNumber == ""){
            return null;
        }

        for(int counter= 0; counter < bankArray.size();counter++) {
            if(bankArray.get(counter).getAccountNumber().equals(accountNumber)){
                return bankArray.get(counter);
            }

        }
        return null;
    }

    public Account removeAccount(String accountNumber){
        if(accountNumber.equals(null) || accountNumber == ""){
            return null;
        }

        for(int counter= 0; counter < bankArray.size();counter++) {
            if(bankArray.get(counter).getAccountNumber().equals(accountNumber)){
                Account temp = bankArray.get(counter);
                bankArray.remove(counter);
                return temp;
            }

        }
        return null;
    }




}





