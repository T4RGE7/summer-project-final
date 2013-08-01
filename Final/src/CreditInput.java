import java.util.Scanner;


public class CreditInput implements Runnable {

	
	public CreditInput() {
		
	}
	
	
	public void run() {
		
		String input = new Scanner(System.in).nextLine();
		Scanner regex = new Scanner(input);
		String number = regex.findInLine(";\\d*=");
		number = number.substring(1, number.length()-1);
		System.out.println(number);
		regex = new Scanner(input);
		String name = regex.findInLine("\\^.*\\^");
		System.out.println(name);
		name = name.substring(1, name.length() - 1);
		System.out.println(name.split("/")[1] + "" + name.split("/")[0]);
	}
	
}
