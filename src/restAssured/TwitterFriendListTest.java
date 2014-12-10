package restAssured;

import static com.jayway.restassured.RestAssured.given;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.LoggingAssert;

import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Headers;
import com.jayway.restassured.response.Response;
/*
 * This class is not complete. Test has to be modified. 
 * Right now it only shows that we can get Friends list, header and cookies when an Oauth call is made to the Twitter api. 
 * 
 */

public class TwitterFriendListTest {
	private static Response res;
	private static String json;
	private Logger log;
	private JsonPath jsonPath;

	@BeforeSuite
	public void setUp() {

		res = given()
				.auth()
				.oauth("LT12encUTAiFfM7RJX9es47t2",
						"m1o1dxCFzneGrT6UcIgbd3uTW6o3WgCi6NojmOfC85rPO3cde3",
						"118304441-DzkNUmYPPwvYbTv46XXHdoDCeHSkIMYYWyG5JsIJ",
						"lfVq6Xy3HEWLXA2ulbtPhDZ9FSX3f2UZFgM0KhTBlX1vB")
				.get("https://api.twitter.com/1.1/friendships/show.json");
		jsonPath = new JsonPath(json).setRoot("ids");

	}

	@Test(groups = "status")
	public void checkStatusSuccess() throws IOException {
		res.then().statusCode(200);
	}

	@Test(groups = "functional")
	public void checkContentType() throws IOException {

		res.then().assertThat().contentType("application/json");
	}

	@Test(groups = "functional")
	public void checkCookies() throws IOException {

		Map<String, String> map = res.getCookies();
		Iterator<String> iter = res.getCookies().keySet().iterator();
		while (iter.hasNext()) {
			String keyvalue = (String) iter.next();
		    System.out.println(" Key :" + keyvalue + " Value :" + map.get(keyvalue));
		}
		
	}
	
	@Test(groups = "functional")
	public void checkHeader() throws IOException {

		Headers allHeaders = res.getHeaders();
		System.out.println(allHeaders.size());

	}

	@Test(groups = "functional")
	public void checkFriendList() throws IOException {
		System.out.println(res.body().asString());
		System.out.println(res.getBody().jsonPath().getList("ids"));
		Iterator<?> ids = res.getBody().jsonPath().getList("ids").iterator();
		while (ids.hasNext()) {
			Object object = (Object) ids.next();
			//System.out.println(object.toString());
			
		}

	}
	
}
