package restAssured;

import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;

public class WeatherTest {
	private static Response res;
	private static String json;

	@BeforeSuite
	public void setUp() {

		res = get("http://api.openweathermap.org/data/2.5/weather?q=London,uk");
		json = res.asString();

	}

	@Test(groups = "status")
	public void checkStatusSuccess()  {
		res.then().assertThat().statusCode(200);
	}

	@Test(groups = "functional")
	public void checkInvalidStatus()  {
		given().expect().statusCode(500).when()
				.get("http://api.openweathermap.org/data/2.5/=");
	}

	@Test(groups = "functional")
	public void checkContentType()  {

		res.then().assertThat().contentType("application/json");
	}

	@Test(groups = "functional")
	public void checkLatttitudeAndLongitude()  {

		JsonPath jsonPath = new JsonPath(json).setRoot("coord");
		Assert.assertEquals(jsonPath.getString(("lon")), "-0.13");
		Assert.assertEquals(jsonPath.getString(("lat")), "51.51");
	}

	@Test(groups = "functional")
	public void checkCountry()  {

		JsonPath jsonPath = new JsonPath(json).setRoot("sys");
		Assert.assertEquals(jsonPath.getString(("country")), "GB");

	}

	@Test(groups = "functional")
	public void checkCookies()  {
		Assert.assertEquals(res.getCookies().size(), 0);
	}

}
