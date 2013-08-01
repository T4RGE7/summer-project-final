
public class Driver {

	public static void main(String[] args) {
		
		Thread t = new Thread(new CreditInput());
		
		t.run();
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
