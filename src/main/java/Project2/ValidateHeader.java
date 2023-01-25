package Project2;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ValidateHeader
{

    public static void getHeader()
    {
        RestAssured.baseURI = "https://maps.googleapis.com";

        RequestSpecification httpRequest = RestAssured.given();

        Response response = httpRequest.request(Method.GET, "https://maps.googleapis.com/maps/api/place/nearbysearch/xml?location=-33.8670");

        //Capture header from response
        String headers = response.getHeader("Pragma");
        System.out.format("The header is:%s ".formatted(headers));
    }

    public static void main(String[] args) {
        getHeader();
    }
}
