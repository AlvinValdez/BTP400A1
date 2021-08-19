package seneca.btp400.w18;
import java.math.BigDecimal;

import java.time.LocalDateTime;
import java.util.*;

import org.finance.accounts.Account;
import org.finance.accounts.Chequing;
import org.finance.accounts.GIC;
import org.finance.accounts.Savings;

import com.little.bank.Bank;

import java.time.format.DateTimeFormatter;

public class BankingApp {

	//Loads the bank with accounts 
	public static void loadBank(Bank bank) {
		GIC JohnDoeGIC = new GIC("John Doe", "D1234", new BigDecimal(6000.00), 2, new BigDecimal(0.015));

		Chequing JohnDoeCheq = new Chequing("John Doe", "E5678", new BigDecimal(15000.00), new BigDecimal(0.75));

		Savings JohnDoeSave = new Savings("John Doe", "F9801", new BigDecimal(8000.00), new BigDecimal(0.015));

		GIC MaryRyanGIC = new GIC("Mary Ryan", "A1234", new BigDecimal(15000.00), 4, new BigDecimal(0.025));

		Chequing MaryRyanCheq = new Chequing("Mary Ryan", "B5678", new BigDecimal(15000.00), new BigDecimal(0.75));

		Savings MaryRyanSave = new Savings("Mary Ryan", "C9012", new BigDecimal(8000.00), new BigDecimal(0.0015));


		bank.addAccount(JohnDoeGIC);
		bank.addAccount(JohnDoeCheq);
		bank.addAccount(JohnDoeSave);

		bank.addAccount(MaryRyanGIC);
		bank.addAccount(MaryRyanCheq);
		bank.addAccount(MaryRyanSave);


	}
	//Displays menu
	public static void displayMenu(String bankName) {
		

			LocalDateTime localDateTime = LocalDateTime.now();
			System.out.println("### Welcome to Bank of " + bankName + " ###");
			System.out.println(localDateTime.format(DateTimeFormatter.ofPattern("h':'m a LLLL d',' uuuu")));

			System.out.print("1. Open an account.\n");
			System.out.print("2. Close an account.\n");
			System.out.print("3. Update an account.\n");
			System.out.print("4. Search.\n");
			System.out.print("5. List all accounts.\n");
			System.out.print("6. Exit.\n\n");
			System.out.print("Please enter your choice: ");





	}

	public static void displayAccount(Account account) {
		System.out.print(account);
	}

	//Displays all accounts in given array
	public static void listAccounts(Account[] listOfAccounts) {
		for (int counter = 0; counter < listOfAccounts.length; counter++) {
			System.out.print(listOfAccounts[counter]);
		}
	}


	public static void main(String[] args) {
		Bank alvin = new Bank("Alvin");
		loadBank(alvin);
		int n = 0;
		String userInput = "";
		String accType = "";
		BigDecimal money;
		String [] tokens;
		Scanner input = new Scanner(System.in);
		Scanner defaultinput = new Scanner(System.in);

		do{

			displayMenu("Alvin");



		n = input.nextInt();
		System.out.println();
		input.nextLine();

		switch(n){

			case 1:
				input.useDelimiter(",|\\n");

					System.out.println("Please enter the account type (SAV/CHQ/GIC): ");

					accType = input.nextLine();
					accType.toUpperCase();

					if(accType.equals("SAV")) {
						System.out.println("Please enter account information at one line\n" +
								"[Full name, account number, balance, interest rate]\n" +
								"(e.g. John Doe, A1234, 1000.00, 3.65):");
						userInput = input.nextLine();

						tokens = userInput.split(",");
						Savings newaccount = new Savings(tokens[0],tokens[1] = tokens[1].replaceAll("\\s+",""),new BigDecimal(tokens[2] = tokens[2].replaceAll("\\s+","")),new BigDecimal(tokens[3] = tokens[3].replaceAll("\\s+","")));

						if(alvin.addAccount(newaccount)==false){
							System.out.println("** FAILED: ACCOUNT CANNOT BE OPENED! ***");

						}else{
						    System.out.println("Account Opened: ");
							System.out.println(newaccount);
                        }


					}
					else if(accType.equals("CHQ")) {
						System.out.println("Please enter account information at one line\n" +
								"[Full name, account number, balance, service charge]\n" +
								"(e.g. John Doe, A1234, 1000.00, 0.25):");
						userInput = input.nextLine();
						tokens = userInput.split(",");

						Chequing newaccount = new Chequing(tokens[0],tokens[1] = tokens[1].replaceAll("\\s+",""),new BigDecimal(tokens[2] = tokens[2].replaceAll("\\s+","")),new BigDecimal(tokens[3] = tokens[3].replaceAll("\\s+","")));

						if(alvin.addAccount(newaccount)==false){
							System.out.println("** FAILED: ACCOUNT CANNOT BE OPENED! ***");

						}else{
							System.out.println("Account Opened: ");
							System.out.println(newaccount);
						}

					}
					else if(accType.equals("GIC")) {
						System.out.println("Please enter account information at one line\n" +
								"[Full name, account number, balance, investment period, annual interest rate]\n" +
								"(e.g. John Doe, A1234, 1000.00, 1, 0.25):");
                        userInput = input.nextLine();
                      
                        //Used to split tokens based on commas
                        tokens = userInput.split(",");
                        
                        //added those .replaceAll to eliminate spaces
                        GIC newaccount = new GIC(tokens[0],tokens[1] = tokens[1].replaceAll("\\s+",""),new BigDecimal(tokens[2] = tokens[2].replaceAll("\\s+","")),Integer.parseInt(tokens[3].replaceAll("\\s+","")),new BigDecimal(tokens[4] = tokens[4].replaceAll("\\s+","")));

						if(alvin.addAccount(newaccount)==false){
							System.out.println("** FAILED: ACCOUNT CANNOT BE OPENED! ***");

						}else{
							System.out.println("Account Opened: ");
							System.out.println(newaccount);
						}

					}
					else {
						System.out.println("Error! Invalid account type!");
                        System.out.println();
                        defaultinput.nextLine();
					}

				break;

			case 2:
				System.out.println("Please enter bank account number of account to be removed at one line: ");
				userInput = defaultinput.nextLine();

				if(alvin.removeAccount(userInput)== null){
					System.out.println("*** FAILED: ACCOUNT CANNOT BE CLOSED! ***");
                    System.out.println();
                    defaultinput.nextLine();
				}else{
					System.out.println("The account "+userInput + " was deleted.");
				}






				break;

			case 3:
				System.out.println();
				defaultinput.nextLine();
				System.out.println("a) Depoist Money.");
                System.out.println("b) Withdraw Money.");
                userInput = defaultinput.nextLine();

                if(userInput.equals("a")){

                    System.out.println("Please enter bank account number of account: ");
                    userInput = defaultinput.nextLine();

                    if(alvin.searchByAccountNumber(userInput).equals( null)) {
                        System.out.println("*** FAILED: ACCOUNT CANNOT BE RETRIEVED! ***");
                        System.out.println();
                        defaultinput.nextLine();
                    }else{
                        System.out.println("Please enter amount to deposit.");
                        money = defaultinput.nextBigDecimal();
                        if(alvin.searchByAccountNumber(userInput).deposit(money)){
                            System.out.println("Account Updated");
                        }else{
                            System.out.println("*** FAILED: ACCOUNT CANNOT BE UPDATED! ***");
                            System.out.println();
                            defaultinput.nextLine();
                        }
                    }

                }else if(userInput.equals("b")){
                    System.out.println("Please enter bank account number of account: ");
                    userInput= defaultinput.nextLine();

                    if(alvin.searchByAccountNumber(userInput).equals( null)) {
                        System.out.println("*** FAILED: ACCOUNT CANNOT BE RETRIEVED! ***");
                        System.out.println(); //Added these things everywhere because it clears buffer taken from: https://stackoverflow.com/questions/10604125/how-can-i-clear-the-scanner-buffer-in-java makes the user have to press enter more than once 
                        defaultinput.nextLine();
                    }else{
                        System.out.println("Please enter amount to withdraw.");
                        money = defaultinput.nextBigDecimal();

                        if(alvin.searchByAccountNumber(userInput).withdraw(money)){
                            System.out.println("Account Updated");

                        }else{
                            System.out.println("*** FAILED: ACCOUNT CANNOT BE UPDATED! ***");
                            System.out.println();
                            defaultinput.nextLine();

                        }

                    }
                }
			    break;

			case 4:
				System.out.println();
				System.out.println();
				defaultinput.nextLine();
				System.out.println("a) Search by account balance.");
                System.out.println("b) Search by account name.");
                System.out.println("c) Search by account number.");
                userInput = defaultinput.nextLine();

                if(userInput.equals( "a")){

                    System.out.println("Please enter bank account balance of account to be retrieved at one line: ");
                    userInput = defaultinput.nextLine();

                    if(alvin.searchByBalance(new BigDecimal(userInput)).length == 0)
                        System.out.print("*** FAILED: ACCOUNT CANNOT BE RETRIEVED! ***");
                    System.out.println();
                    defaultinput.nextLine();

                   Account [] temp = alvin.searchByBalance(new BigDecimal(userInput));
                   for(int counter = 0; counter < temp.length;counter++){
                       System.out.print(temp[counter]);
                   }


                }else if(userInput.equals("b")){
                    System.out.println("Please enter bank account name of account to be retrieved at one line: ");
                    userInput = defaultinput.nextLine();

                    if(alvin.searchByAccountName(userInput).length == 0)
                        System.out.print("*** FAILED: ACCOUNT CANNOT BE RETRIEVED! ***");
                    System.out.println();
                    defaultinput.nextLine();

                    Account [] temp = alvin.searchByAccountName(userInput);

                    for(int counter = 0; counter < temp.length;counter++){
                        System.out.print(temp[counter]);
                    }


                }else if(userInput.equals("c")){
                    System.out.println("Please enter bank account number of account to be retrieved at one line: ");
                    userInput = defaultinput.nextLine();

                    if(alvin.searchByAccountNumber(userInput).equals( null)) {
                        System.out.println("*** FAILED: ACCOUNT CANNOT BE RETRIEVED! ***");
                        System.out.println();
                        defaultinput.nextLine();
                    }else{
                        System.out.print(alvin.searchByAccountNumber(userInput));
                    }

                }else{
                    System.out.print("Invalid choice.");
                }

				break;

			case 5:
				for(int counter = 0; counter < alvin.getBankArray().size(); counter++){
					System.out.print(alvin.getBankArray().get(counter));
				}
				break;

			case 6:
				System.out.println("Bye have a great time!");
				input.close();
				defaultinput.close();
				break;

			default: System.out.print("Invalid choice.");
				break;
		}
	}while(n != 6);

		}

}
