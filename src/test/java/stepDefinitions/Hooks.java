package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	
	@Before("@DeletePlace")
	public void beforeScenario() throws IOException
	{
	if (stepDefinition.place_id==null)
	{
		stepDefinition SD = new stepDefinition();
		SD.user_is_on_add_place_payload("vishal", "chinies", "India");
		SD.user_calls_using_http_request("AddPlaceAPI", "POST");
		SD.verify_place_id_created_maps_to_using("vishal", "getPlaceAPI");
		
	}

}
}