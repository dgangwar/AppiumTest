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
 * This class is not complete. Test has to be added. 
 * 
 */

public class TwitterUserTimeLine {
	private static Response res;

	@BeforeSuite
	public void setUp() {

		res = given()
				.auth()
				.oauth("LT12encUTAiFfM7RJX9es47t2",
						"m1o1dxCFzneGrT6UcIgbd3uTW6o3WgCi6NojmOfC85rPO3cde3",
						"118304441-DzkNUmYPPwvYbTv46XXHdoDCeHSkIMYYWyG5JsIJ",
						"lfVq6Xy3HEWLXA2ulbtPhDZ9FSX3f2UZFgM0KhTBlX1vB")
				.get("https://api.twitter.com/1.1/statuses/user_timeline.json");

	}

	@Test(groups = "status")
	public void checkStatusSuccess() throws IOException {
		res.then().statusCode(200);
	}

	@Test(groups = "functional")
	public void checkContentType() throws IOException {

		res.then().assertThat().contentType("application/json");
	}

}
