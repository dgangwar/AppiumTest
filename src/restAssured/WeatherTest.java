package restAssured;

import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.LoggingAssert;

import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;

public class WeatherTest {
	private static Response res;
	private static String json;
	private Logger log;

	@BeforeSuite
	public void setUp() {

		res = get("http://api.openweathermap.org/data/2.5/weather?q=London,uk");
		json = res.asString();
		log = Logger.getLogger(LoggingAssert.class.getName());
		
	}

	@Test(groups = "status")
	public void checkStatusSuccess() throws IOException {
		res.then().assertThat().statusCode(200);
		log.info("This is Status check message");
	}

	@Test(groups = "functional")
	public void checkInvalidStatus() throws IOException {
		given().expect().statusCode(500).when()
				.get("http://api.openweathermap.org/data/2.5/=");
	}

	@Test(groups = "functional")
	public void checkContentType() throws IOException {

		res.then().assertThat().contentType("application/json");
	}

	@Test(groups = "functional")
	public void checkLatttitudeAndLongitude() throws IOException {

		JsonPath jsonPath = new JsonPath(json).setRoot("coord");
		Assert.assertEquals(jsonPath.getString(("lon")), "-0.13");
		Assert.assertEquals(jsonPath.getString(("lat")), "51.51");
	}

	@Test(groups = "functional")
	public void checkCountry() throws IOException {

		JsonPath jsonPath = new JsonPath(json).setRoot("sys");
		Assert.assertEquals(jsonPath.getString(("country")), "GB");

	}

	/**
	 * This method is not implemented yet.
	 * 
	 * @throws IOException
	 */
	@Ignore
	@Test(groups = "functional")
	public void checkOAuth() throws IOException {

		given().auth().oauth2("");

	}

	@Test(groups = "functional")
	public void checkCookies() throws IOException {

		Assert.assertEquals(res.getCookies().size(), 0);
	}

}
