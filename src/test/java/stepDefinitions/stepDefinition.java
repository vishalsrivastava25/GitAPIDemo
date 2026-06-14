package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;
//import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import Pojo.AddPlace;
import Pojo.Location;
import Pojo.PostResponse;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIresource;
import resources.TestDataBuild;
import resources.Utils;

public class stepDefinition extends Utils {

	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	TestDataBuild td = new TestDataBuild();
	JsonPath js;
	APIresource resourceAPI;
	static String place_id;
	
	@Given("User is on ADD Place Payload {string} {string} {string}")
public void user_is_on_add_place_payload(String name, String language,String address) throws IOException {
	RestAssured.useRelaxedHTTPSValidation();
	//resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	res = given().log().all().spec(requestSpecification())
	.body(td.AddPlacePayload(name,language, address));
}

@When("User calls {string} using {string} http request")
public void user_calls_using_http_request(String resource, String method) {
		
	
	APIresource resourceAPI = APIresource.valueOf(resource);
	System.out.println(resourceAPI.GetResource());
	
	
	
	resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	
	if (method.equalsIgnoreCase("POST"))
	{
		response = res.when().post(resourceAPI.GetResource());
				//.then().log().all().assertThat().spec(resspec).extract().response();
	}
	else if (method.equalsIgnoreCase("GET"))
	{
	response = res.when().get(resourceAPI.GetResource());
			//.then().log().all().assertThat().spec(resspec).extract().response();
	}
}
@Then("The API call got success with statuscode {int}")
public void the_api_call_got_success_with_statuscode(Integer int1) {
	assertEquals(response.getStatusCode(),200);
	}
@Then("{string} in response body is {string}")
public void in_response_body_is(String KeyValue, String EcpectedValue) {
	
	assertEquals(getJsonPath(response,KeyValue),EcpectedValue);	
}
@Then("Verify place_Id created maps to {string} using {string}")
public void verify_place_id_created_maps_to_using(String Expectedname, String resource) throws IOException {
	
	
	place_id = getJsonPath(response,"place_id");	
	res = given().log().all().spec(requestSpecification()).queryParam("place_id", place_id);
			user_calls_using_http_request(resource, "GET");
			assertEquals(getJsonPath(response,"name"),Expectedname);
}

@Given("User is on Delete Place Payload")
public void user_is_on_delete_place_payload() throws IOException {
   //String xyz = place_id;
	res=given().log().all().spec(requestSpecification()).body(td.DeletePlacePayload(place_id));
}
	
}
