package Project1;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Update_Address
{
    // validate if Add Place API is working as expected
    //Add place-> Update Place with New Address -> Get Place to validate if New address is present in response

    public String updatePlace()
    {
        Post_Request ps_Obj = new Post_Request();
        String placeId = ps_Obj.getPlaceId();

        final String updateAPIResource = "maps/api/place/update/json"; //update

        given().queryParam("key", "qaclick123").header("Content-Type","application/json")
                .body(this.getBody(placeId, "Kaliyaganj, India"))
                .when().put(updateAPIResource)
                .then().assertThat().statusCode(200)
                .body("msg", equalTo("Address successfully updated"));

        return placeId;
    }

    private String getBody(String placeId, String address)
    {
        System.out.format("Place id from getBody %s ".formatted(placeId));
        return "{\n" +
                "    \"place_id\": \"" + placeId + "\",\n" +
                "    \"address\": \"" + address + "\",\n" +
                "    \"key\": \"qaclick123\"\n" +
                "}";
    }
}


