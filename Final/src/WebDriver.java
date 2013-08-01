
public class WebDriver {

	public static void main(String[] args) {
		
		WebSender test = new WebSender("https://www.virginia.edu/cgi-local/ldapweb", "whitepages", "jpr4gc");
		System.out.println(test.getResponse());
		
	}
	
}
