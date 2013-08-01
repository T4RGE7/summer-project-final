/**
 * 
 * @author James Roberts jpr242
 * 
 */

public class WebDriver {

	public static void main(String[] args) {
		
		WebCCSender test = new WebCCSender("https://www.virginia.edu/cgi-local/ldapweb", "whitepages", "jpr4gc");
		System.out.println(test.getResponse());
		
	}
	
}
