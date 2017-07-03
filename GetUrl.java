import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetUrl {
	public String getPageContent(String strUrl,String strPostRequest,int maxLength){
		StringBuffer buffer = new StringBuffer();
		System.setProperty("sun.net.client.defaultConnectTimeout", "5000");
		System.setProperty("sun.net.client.defaultReadTimeout", "5000");
		try{
			URL newUrl = new URL(strUrl);
			HttpURLConnection hConnect = (HttpURLConnection) newUrl.openConnection();
			if(strPostRequest.length() > 0) {
				hConnect.setDoOutput(true);
				OutputStreamWriter out = new OutputStreamWriter(hConnect.getOutputStream());
				out.write(strPostRequest);
				out.flush();
				out.close();
			}
			
			BufferedReader rd = new BufferedReader(new InputStreamReader(hConnect.getInputStream()));
			int ch;
			for(int length = 0; (ch = rd.read())> -1 && (maxLength<=0 || length<maxLength);length++)
				buffer.append((char) ch);
			String s = buffer.toString();
			s.replaceAll("//&[a-zA-Z]{1,10};", "").replaceAll("<[^>]*>", "");
			System.out.println(s);
			rd.close();
			hConnect.disconnect();
			return buffer.toString().trim();
		} catch (Exception e){
			return null;
		}
	}
	
	
	public static void main(String args[]){
		String url = "https://www.panda.tv";
		String keyword = "haha";
		GetUrl p =new GetUrl();
		p.getPageContent(url, "post", 100500);
		
	}
}
