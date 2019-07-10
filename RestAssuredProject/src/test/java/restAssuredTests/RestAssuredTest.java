package restAssuredTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredTest {

	RequestSpecification httpRequest;
	Response response;

	@Test
	public void GetWeatherDetails() {
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

		// Get the RequestSpecification of the request that you want to sent to the server. The server is specified by the BaseURI that we have specified in the above step.
		httpRequest = RestAssured.given();

		// Make a request to the server by specifying the method Type and the method URL.
		// This will return the Response from the server. Store the response in a variable.
		response = httpRequest.request(Method.GET, "/Hyderabad");
		 int statusCode = response.getStatusCode();
		 System.err.println("Status code is "+statusCode);
		 // Assert that correct status code is returned.
		 Assert.assertEquals(statusCode /*actual value*/, 200 /*expected value*/, "Correct status code returned");

		// Now let us print the body of the message to see what response we have recieved from the server
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
		
		// Get the status line from the Response and store it in a variable called statusLine
		 String statusLine = response.getStatusLine();
		 System.out.println("Status line is "+statusLine);
		 Assert.assertEquals(statusLine /*actual value*/, "HTTP/1.1 200 OK" /*expected value*/, "Correct status code returned");
		
		

	}

}