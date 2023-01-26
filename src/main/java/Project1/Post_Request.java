package Project1;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Post_Request
{
    /**
     *
     * give - all input details
     * when - submit the api :resource, http method
     * then - validate the response
     */

    public String createResponse()
    {
        RestAssured.baseURI = "https://rahulshettyacademy.com";

        /**
         *
         * How to send a request
         * given() -> query parameters -> header -> body -> when() -> post with resource -> validate the response with then()
         */
        final String addAPIResource = "maps/api/place/add/json"; //add

        String respose = given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
                .body(JsonPayload.AddPlace()).when().post(addAPIResource).then().log().all().assertThat().statusCode(200)
                .body("scope", equalTo("APP"))
//                .header("User-Agent", "PostmanRuntime/7.30.0") Its failing
                .header("server", "Apache/2.4.41 (Ubuntu)")
                .extract().response().asString();    //To extract the response
//                .toString();

        System.out.format("The response which is generated: %s".formatted(respose));
        return respose;
    }

    public String getPlaceId()
    {
        try
        {
            String res = createResponse();
            JsonPath js = new JsonPath(res); // Parsing string to json
            String placeId = js.getString("place_id");
            System.out.format("This is place id '%s'".formatted(placeId));
            return placeId;
        }
        catch (Exception e)
        {
            System.out.format("Failed to get place id for %s".formatted());
        }
        return "#not_found";
    }
}
