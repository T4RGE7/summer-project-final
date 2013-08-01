
public class WebCCSender extends WebSender {

	public WebCCSender(String URLText, String mapKey, String mapValue) {
		super(URLText, mapKey, mapValue, "POST", "UTF-8", true, true);
	}
	
}
