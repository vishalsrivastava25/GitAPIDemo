 Feature: Validating Place API
 @AddPlace @Regression
 Scenario Outline: Verify if place is successfully added using AddPlace API
 Given User is on ADD Place Payload "<name>" "<language>" "<address>"
 When User calls "AddPlaceAPI" using "Post" http request
 Then The API call got success with statuscode 200
 And "status" in response body is "OK"
 And "scope" in response body is "APP"
 And Verify place_Id created maps to "<name>" using "getPlaceAPI"
  
 Examples:
 | name   | language | address           |
 |PropHome| English	 | alpharetta doe dr.|
# |FarmHome| Hindi	 	| Woodstock 466 Ravine dr.|

@DeletePlace @Regression
Scenario: Verify if place is successfully deleted using DeletePlace API
Given User is on Delete Place Payload
When User calls "DeletePlaceAPI" using "Post" http request
Then The API call got success with statuscode 200
And "status" in response body is "OK"