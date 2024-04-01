package API_Concept;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class CookiesAndHeaders
{
    static Response getRes()
    {
        Response response = given().when().get("https://dev.azure.com/BIB-IT-AzurePipeline/");
        return response;
    }
    static void validateHeaders()
    {
        Response response = given().when().get("https://dev.azure.com/BIB-IT-AzurePipeline/");
        response.then()
                .header("Content-Type", "text/html")
                .and()  //not mandatory to add
                .header("Server", "gws");
    }

    static void getBody()
    {
        getRes().then().log().body();
    }

    static void getHeaders()
    {
        getRes().then().log().headers();
    }

    static void getCookies()
    {
        getRes().then().log().all().extract().cookies();
    }

    public static void main(String[] args)
    {
        //Print all headers
        Headers headers = getRes().getHeaders();
        for(Header itm :  headers)
        {
            System.out.println(itm.getName()+" - "+itm.getValue());
        }
    }
}
