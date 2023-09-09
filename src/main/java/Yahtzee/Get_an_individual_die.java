package Yahtzee;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

public class Get_an_individual_die
{
    private static Response getCall()
    {
        Response res = RestAssured.given().baseUri("http://localhost:8081").when().get("/die/5");

        return res;

    }

    private static String status_validation(int code)
    {
        return switch (code)
                {
                    case 200 :
                        yield "Individual die";

                    case 400 :
                        yield "Bad request";

                    default:
                        throw new IllegalStateException("Unexpected value: " + code);
                };

    }

    public static void main(String[] args)
    {
        Response response = getCall();
        response.then().log().all();
        System.out.println("Headers: -> "+ response.getHeaders());
        System.out.println("Content-Type: -> "+response.getHeader("Content-Type"));
        System.out.println(status_validation(response.getStatusCode()));
    }
}
