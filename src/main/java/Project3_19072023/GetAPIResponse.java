package Project3_19072023;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetAPIResponse
{
    private static String getResponse()
    {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com/booking";

        String response = given().contentType(ContentType.JSON).when().get().then().log().all().assertThat().statusCode(200)
                .statusLine("HTTP/1.1 200 OK").extract().response().asString();

        return response;
    }

    @Test
    public void main()
    {
        this.getApiResponse_Test1();
    }

    public void getApiResponse_Test1()
    {
        Response response = RestAssured.given().contentType(ContentType.JSON).baseUri("https://restful-booker.herokuapp.com/booking")
                .when().post().then().assertThat().header("Server", "Cowboy")
                .statusCode(200).extract().response();

        Response response1 = RestAssured.given().contentType(ContentType.JSON).baseUri("https://restful-booker.herokuapp.com/booking")
                .when().post();


        String converted_Response = response.asString();
//        Assert.assertTrue(converted_Response.contains("bookingid"));

    }
}
