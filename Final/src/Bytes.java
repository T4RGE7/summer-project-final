import java.io.IOException;


public class Bytes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		int c = '\0';
		
		while(true) {
			try {
				c = System.in.read();
				if(c == '\n') {
					break;
				}
				System.out.println(c + " : " + (char)c);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
