import java.util.Scanner;

public class Lab3main {
	
	private static Dollar dollar = new Dollar();
	private static Pound pound = new Pound();
	
	private static Currency[] currencyObjs = {pound, dollar};
	
	private static Scanner input = new Scanner(System.in); 
	
	public static void main(String[] args) {
		
		String operation;
		String[] command;
		Currency tempCurrency;
		
		printCurrentValues();
		
		do {
			operation = input.nextLine();
			if(operation.equals("q")) {
				System.exit(0);
			}
			command = operation.split(" ");
			if(command[3].toLowerCase().equals("dollar")) {
				tempCurrency = new Dollar(Double.parseDouble(command[2]));
			}
			else if(command[3].toLowerCase().equals("pound")) {
				tempCurrency = new Pound(Double.parseDouble(command[2]));
			}
			else {
				tempCurrency = new Pound();
			}
			if(command[0].equals("a")) {
				if(command[1].equals("p")) {
					try {
						currencyObjs[0].add(tempCurrency);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
				}
				else if(command[1].equals("d")) {
					try {
						currencyObjs[1].add(tempCurrency);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
				}
			}
			else if(command[0].equals("s")){
				if(command[1].equals("p")) {
					try {
						currencyObjs[0].subtract(tempCurrency);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
				}
				else if(command[1].equals("d")) {
					try {
						currencyObjs[1].subtract(tempCurrency);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
				}
			}
			printCurrentValues();
		} while(operation != "q");	
				
		
		
	}
	
	public static void printCurrentValues() {
		for(Currency currency : currencyObjs) {
			currency.print();
		}
		System.out.println();
	}

}
