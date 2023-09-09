package Yahtzee;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Set_Name_Of_The_Player
{
    private static String getPayload()
    {
        return "{\n" +
                "  \"name\": \"foo\"\n" +
                "}";
    }
    private static Response putCall()
    {
        RestAssured.baseURI = "http://localhost:8081";
//        RequestSpecification request = RestAssured.given().contentType("application/json");
//        Response res = request.body(getPayload()).put("/playerName");

        Response res = RestAssured.given().baseUri("http://localhost:8081").body(getPayload()).put("/playerName");
        return res;
    }

    private static String getStatus(int code)
    {
        return switch (code)
                {
                    case 204:
                        yield "Name set successfully";
                    case 400:
                        yield "Bad Request";
                    case 401:
                        yield "Unauthorized";
                    default:
                        yield "Not_Found";
                };
    }

    public static void main(String[] args)
    {
        Response response = putCall();
        response.then().log().all();

        System.out.println(getStatus(response.getStatusCode()));


    }
}
