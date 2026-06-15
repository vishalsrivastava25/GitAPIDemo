package resources;

public enum APIresource {
	
	
	AddPlaceAPI("/maps/api/place/add/json"), 
	getPlaceAPI("/maps/api/place/get/json"),
	UpdatePlaceAPI("/maps/api/place/update/json"),
	DeletePlaceAPI("/maps/api/place/delete/json");

	private String resource;
	
	APIresource(String resource) {
		this.resource=resource;
	}
	
	
	public String GetResource() 
	{ System.out.println("2nd project commit");
	System.out.println("3rd project commit");
		return resource;
	}
 
}
