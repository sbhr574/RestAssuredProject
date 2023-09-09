package Yahtzee;

import Response_Validation.Validation_Util;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class Get_Name_Of_Player
{
    public static Response getResponse()
    {
        RestAssured.baseURI = "http://localhost:8080/playerName";
        String response = "not Found";

        try
        {
            return given().when().get().then().log().all().assertThat().statusCode(200)
                    .extract().response();
        }
        catch (Exception e)
        {
            System.out.println("Unexpected Error %s".formatted(e));
        }

        return null;
    }

    public static void main(String[] args) {
//        System.out.println(getResponse().asString());
        String str = RestAssured.given().baseUri("http://localhost:8081/playerName").when().get()
                .then().assertThat().log().all().statusCode(200).extract().response().asString();
        System.out.println(str);
        JSONObject js = new JSONObject(str);
        System.out.println(Validation_Util.parseObject(js, "status"));
        System.out.println(Validation_Util.getKey(new JSONObject(str), "status"));
    }
}
