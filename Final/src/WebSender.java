/**
 * 
 * @author James Roberts jpr242
 * 
 */

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;


public class WebSender {
	
	private String requestMethod;
	private String textFormat;
	private boolean doInput, doOutput;
	
	private String URLTxt;
	private String mapKey;
	private String mapValue;
	
	public WebSender(String URLTxt, String mapKey, String mapValue, String requestMethod, String textFormat, boolean doInput, boolean doOutput) {
		this.URLTxt = URLTxt;
		this.mapKey = mapKey;
		this.mapValue = mapValue;
		this.requestMethod = requestMethod;
		this.textFormat = textFormat;
		this.doInput = doInput;
		this.doOutput = doOutput;
	}
	
	public String getResponse() {
		Map<String, String> toSend = new HashMap<String, String>();
		toSend.put(this.mapKey, this.mapValue);
		return this.getData(toSend);
	}

	private String getData(Map<String, String> toSend) {
		URL siteURL = null;
		HttpsURLConnection connection = null;
		DataOutputStream out = null;
		Set<String> keys = null;
		Iterator<String> keyIterator = null;
		BufferedReader reader = null;
		String content = "";
		String toReturn = "";
		
		try {
			siteURL = new URL(this.URLTxt);
			connection = (HttpsURLConnection)siteURL.openConnection();
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
		try {
			connection.setRequestMethod(this.requestMethod);
			connection.setDoOutput(this.doOutput);
			connection.setDoInput(this.doInput);
		} catch (ProtocolException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		
		try {
			out = new DataOutputStream(connection.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		keys = toSend.keySet();
		keyIterator = keys.iterator();
		
		for(int i = 0; keyIterator.hasNext(); i++) {
			Object key = keyIterator.next();
			if(i != 0) {
				content += "&";
			}
			try {
				content += key + "=" + URLEncoder.encode(toSend.get(key), this.textFormat);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		
		
		try {
			out.writeBytes(content);
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			String lineIn = "";
			while((lineIn = reader.readLine()) != null) {
				toReturn += lineIn;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return toReturn;
	}
	
}
