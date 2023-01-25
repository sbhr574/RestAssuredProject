package Project1;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class GetUpdatedAddress
{

    public String getAddress()
    {
        try
        {
            Update_Address upAddObj = new Update_Address();
            String placeId = upAddObj.updatePlace();
            final String getAPIResource = "maps/api/place/get/json"; //get

            String getResponse = given().log().all().queryParam("key", "qaclick123")
                    .queryParam("place_id", placeId)
                    .when().get(getAPIResource)
                    .then().assertThat().log().all().statusCode(200).extract().response().asString();

            JsonPath js = new JsonPath(getResponse);
            String actualAddress = js.getString("address");
            System.out.format("Actual address is '%s' ".formatted(actualAddress));

            return actualAddress;
        }
        catch (Exception e)
        {
            System.out.format("Failed to get place id for %s".formatted(e));
        }

        return "#Not_Found#";
    }
}
