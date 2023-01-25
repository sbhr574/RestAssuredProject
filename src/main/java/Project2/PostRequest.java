package Project2;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class PostRequest
{

    public void createResponse()
    {
        RestAssured.baseURI = "https://rahulshettyacademy.com";

        RequestSpecification httpRequest = RestAssured.given();

//        JSONObject requestparams = new JSONObject();

    }
}
