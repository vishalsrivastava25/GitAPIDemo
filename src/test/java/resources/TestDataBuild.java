package resources;

import java.util.ArrayList;
import java.util.List;

import Pojo.AddPlace;
import Pojo.Location;

public class TestDataBuild {
	
	public AddPlace AddPlacePayload(String name, String language, String address)
	{
		AddPlace ad = new AddPlace();
		ad.setAccuracy(50);
		ad.setName(name);
		ad.setPhone_number("(+91) 983 893 3937");
		ad.setAddress(address);
		ad.setWebsite("http://google.com");
		ad.setLanguage(language);
		
		List<String> typ = new ArrayList<String>();
		typ.add("shoe park");
		typ.add("shop");
		ad.setTypes(typ);
		
		Location loc = new Location();
		loc.setLat(-38.383494);
		loc.setLng(33.427362);
		ad.setLocation(loc);
		return ad;
	}

	public String DeletePlacePayload(String place_id) 
	{
		//System.out.println("Delete placeid is= "+place_id);
		return "{\r\n    \"place_id\":\""+place_id+"\"\r\n}";
		
	}
	
}
