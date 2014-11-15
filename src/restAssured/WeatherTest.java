package restAssured;

import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;

public class WeatherTest {
	private static Response res;

	@BeforeClass
	public void setUp() {
		
		res = get("http://api.openweathermap.org/data/2.5/weather?q=London,uk");
	}

	@Test(groups = "header")
	public void checkStatus() throws IOException {

		res.then().assertThat().statusCode(200);

	}

	@Test(groups = "header")
	public void checkContentType() throws IOException {

		res.then().assertThat().contentType("application/json");
	}

	@Test
	public void checkJsonNode() throws IOException {

		String json = res.asString();
		System.out.println(json.length());
		JsonPath jsonPath = new JsonPath(json).setRoot("coord");
		System.out.println(jsonPath.getString(("lon")));
		System.out.println(jsonPath.getString(("lat")));
		jsonPath.getString(("lon")).equals("-0.13");
		jsonPath.getString(("lat")).equals("-0.13");

	}

	@Test
	public void checkOAuth() throws IOException {

		given().auth().oauth2("");

	}

	@Test(groups = "header")
	public void checkCookies() throws IOException {

		Map<String, String> allCookies = res.getCookies();
		System.out.println(allCookies.size());
	}

}
