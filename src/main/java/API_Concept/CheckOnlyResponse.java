package API_Concept;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class CheckOnlyResponse
{
    static Response getRes()
    {
        Response response = given().when().get("https://dev.azure.com/BIB-IT-AzurePipeline/");
        return response;
    }

    public static void main(String[] args) {
        int status = getRes().statusCode();
        String cookies = getRes().getCookie("");

        String header = getRes().getHeader("Content-type");

        //Get the response as a string
        getRes().then().log().all().extract().response().asString();
    }
}
