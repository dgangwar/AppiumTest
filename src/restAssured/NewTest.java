package restAssured;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.RestAssured;
import static com.jayway.restassured.RestAssured.*;
import static com.jayway.restassured.matcher.RestAssuredMatchers.*;
import com.jayway.restassured.response.Response;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClientBuilder;
import org.hamcrest.Matchers.*;

public class NewTest
{
    
     
  //@Test
  public void f() 
   {
      
      Response res = get("http://api.openweathermap.org/data/2.5/weather?q=London,uk");
      System.out.println(res);
     
  }
   
  @Test
   public void
    givenRequestWithNoAcceptHeader_whenRequestIsExecuted_thenDefaultResponseContentTypeIsJson()
    throws ClientProtocolException, IOException{
      // Given
      String jsonMimeType = "application/json";
      HttpUriRequest request = new HttpGet( "http://api.openweathermap.org/data/2.5/weather?q=London,uk" );
    
      // When
      HttpResponse response = HttpClientBuilder.create().build().execute( request );
    
      // Then
      String mimeType = ContentType.getOrDefault(response.getEntity()).getMimeType();
      Assert.assertEquals( jsonMimeType, mimeType );
   }
}
