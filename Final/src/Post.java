import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class Post {
	public static void main(String[] args) throws Exception{
//		Map<String, String> data = new HashMap<String, String>();
//		data.put("whitepages", "jpr4gc");
//		String url = "http://www.virginia.edu/cgi-local/ldapweb";
//		URL siteUrl = new URL(url);
//		HttpURLConnection connection = (HttpURLConnection)siteUrl.openConnection();
//		connection.setRequestMethod("POST");
//		connection.setDoOutput(true);
//		connection.setDoInput(true);
//		
//		DataOutputStream out = new DataOutputStream(connection.getOutputStream());
//		Set keys = data.keySet();
//		Iterator keyIter = keys.iterator();
//		String content = "";
//		for (int i = 0; keyIter.hasNext(); i ++){
//			Object key = keyIter.next();
//			if (i != 0){
//				content += "&";
//			}
//			content += key + "=" + URLEncoder.encode(data.get(key), "UTF-8");
//		}
//		
//		System.out.println(content);
//		out.writeBytes(content);
//		out.flush();
//		out.close();
//		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//		String line = "";
//		while((line=in.readLine())!=null) {
//			System.out.println(line);
//		}
//		in.close();
	
		
		try{
			PrintWriter out = new PrintWriter("mined1"+".csv");
			

			
//		for (int i = 1; i <= 27; i++){
//			Character firstChar = (char) 0;
//			//String compID = "";
//			if (i != 27){
//				firstChar = (char)(i + 96);
//				//compID += firstChar + "";
//			}
//			
			
			for (int j = 1; j <= 26; j++){
				Character secondChar = (char)(j + 96);
//				for (int n = 1; n <= 26; n++){
//					Character thirdChar = (char)(n + 96);
					for (int b = 0; b <= 9; b++){
						Character fourthChar = (char) (b+48);
						for (int g = 1; g <= 26; g++){
							Character fifthChar = (char)(g + 96);
							for (int t = 1; t <= 26; t++){
								
								
								
								
								
								Character sixthChar= (char)(t + 96);
								//String compID = firstChar.toString() + secondChar.toString() + thirdChar.toString() + fourthChar.toString() + fifthChar.toString() + sixthChar.toString() + "";
								String compID = 'j'+""+secondChar.toString()+'r'+fourthChar.toString()+fifthChar.toString()+sixthChar.toString();
								Map<String, String> data = new HashMap<String, String>();
								data.put("whitepages", compID);
								ArrayList<String> results = getData(data);
								if (results.get(2).equals("<br clear=all><h3>No matching entries were found</h3>") == false){
								out.println(results.toString());
								}
								
							}
						}
						}
					}
				//}
		//	}
		
			out.close();
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public static ArrayList<String> getData(Map<String, String> data) throws Exception{
		ArrayList<String> toReturn = new ArrayList<String>();
		String url = "http://www.virginia.edu/cgi-local/ldapweb";
		URL siteUrl = new URL(url);
		HttpURLConnection connection = (HttpURLConnection)siteUrl.openConnection();
		connection.setRequestMethod("POST");
		connection.setDoOutput(true);
		connection.setDoInput(true);
		
		DataOutputStream out = new DataOutputStream(connection.getOutputStream());
		Set keys = data.keySet();
		Iterator keyIter = keys.iterator();
		String content = "";
		for (int i = 0; keyIter.hasNext(); i ++){
			Object key = keyIter.next();
			if (i != 0){
				content += "&";
			}
			content += key + "=" + URLEncoder.encode(data.get(key), "UTF-8");
		}
		
		System.out.println(content);
		out.writeBytes(content);
		out.flush();
		out.close();
		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String line = "";
		while((line=in.readLine())!=null) {
			toReturn.add(line);
		}
		in.close();
		toReturn.add("////end of user\\\\");
		return toReturn;
	}
}