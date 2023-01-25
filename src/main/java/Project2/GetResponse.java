package Project2;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class GetResponse
{

    public static Response getResponse()
    {
        RestAssured.baseURI = "https://rahulshettyacademy.com";

        //Request object. Sending request.
        RequestSpecification httpRequest = RestAssured.given().queryParam("key", "qaclick123")
                .queryParam("place_id", "7144545bb9d71c2aac7ee2a3655f1645");

        //Response object
        Response response = httpRequest.request(Method.GET, "/maps/api/place/get/json");

        return response;
    }

    public static void validateResponseCode(Response response)
    {
        int actualStatusCode = response.getStatusCode();
        System.out.format("Response status code is: %s".formatted(actualStatusCode));
        Assert.assertEquals(actualStatusCode, 200);
    }

    public static void validateResponseBody()
    {

    }

    public static void main(String[] args) {
        Response response = getResponse();
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is: " + responseBody);
        validateResponseCode(response);
        System.out.println("Response status code is: " + response.getStatusLine());


    }
}
