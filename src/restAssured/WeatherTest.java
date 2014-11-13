package restAssured;

import static com.jayway.restassured.RestAssured.get;
import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import util.ReadData;
import com.jayway.restassured.response.Response;

public class WeatherTest
{
	private static Response res ;
     
  @BeforeClass
  public void setUp() 
   {
      res = get("http://api.openweathermap.org/data/2.5/weather?q=London,uk");
          
  }
   
  @Test
   public void
    givenRequestWithNoAcceptHeader_whenRequestIsExecuted_thenDefaultResponseContentTypeIsJson()
    throws ClientProtocolException, IOException{
      // Given
      String jsonMimeType = ReadData.getProperty("contentType");
      HttpUriRequest request = new HttpGet( "http://api.openweathermap.org/data/2.5/weather?q=London,uk" );
    
      // When
      HttpResponse response = HttpClientBuilder.create().build().execute( request );
    
      // Then
      String mimeType = ContentType.getOrDefault(response.getEntity()).getMimeType();
      Assert.assertEquals( jsonMimeType, mimeType );
   }
}
