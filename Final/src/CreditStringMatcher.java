import java.util.Scanner;


public class CreditStringMatcher {

	private String rawIn, track[];
	
	public CreditStringMatcher(String rawIn) {
		this.rawIn = rawIn;
		if(this.rawIn.contains(";")) {
			this.track = this.rawIn.split(";");
		} else {
			this.track = new String[]{this.rawIn};
		}		
	}
	
	public CreditCard getCreditCard() {
		String firstName, lastName, pan, expM, expY, security;
		
		pan = this.trackOnePan();
		
		
		return new CreditCard(firstName, lastName, pan ,expM, expY, security);
	}
	
	public String trackOnePan() {
		String toReturn = "";
		Scanner regex = new Scanner(track[0]);
		toReturn = regex.findInLine("%B\\d*\\^");
		regex.close();
		toReturn = (toReturn != null ? toReturn.substring(2, toReturn.length() - 1) : "");		
		return toReturn;	
	}
	
	public String[] trackOneName() {
		String[] toReturn = {"",""};
		Scanner regex = new Scanner(track[0]);
		String temp = regex.findInLine("\\^[A-Z 0-9/$]*\\^");
		regex.close();
		
		
		return toReturn;
	}
	
	
	
}
