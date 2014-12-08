package restAssured;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
 
 
public class Tw {
 
	  static String AccessToken = "118304441-DzkNUmYPPwvYbTv46XXHdoDCeHSkIMYYWyG5JsIJ";
	  static String AccessSecret = "lfVq6Xy3HEWLXA2ulbtPhDZ9FSX3f2UZFgM0KhTBlX1vB";
	  static String ConsumerKey = "LT12encUTAiFfM7RJX9es47t2";
	  static String ConsumerSecret = "m1o1dxCFzneGrT6UcIgbd3uTW6o3WgCi6NojmOfC85rPO3cde3";
 
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
	   
//	   System.setProperty("socksProxyHost", "localhost");
//      System.setProperty("socksProxyPort", "9050");
//      System.setProperty("socksProxyVersion", "5");
	   
		OAuthConsumer consumer = new CommonsHttpOAuthConsumer(
                ConsumerKey,
                ConsumerSecret);
 
        consumer.setTokenWithSecret(AccessToken, AccessSecret);
        HttpGet request = new HttpGet("https://api.twitter.com/1.1/followers/list.json");
        consumer.sign(request);
 
        HttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(request);
 
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println(statusCode + ":" + response.getStatusLine().getReasonPhrase());
        System.out.println(IOUtils.toString(response.getEntity().getContent()));
	}
}