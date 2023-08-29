package Project3_19072023;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.minidev.json.JSONObject;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;

import static io.restassured.RestAssured.given;

public class ResposeValidation
{
    public static Response getRespose()
    {
        RestAssured.baseURI = "https://reqres.in";

        Response response = given().contentType(ContentType.JSON).basePath("api/users?page=2").when().get()
                .then().extract().response();

        return response;

    }

    public static String getStringResponse()
    {
        RestAssured.baseURI = "https://reqres.in";

        String response = given().contentType(ContentType.JSON).basePath("api/users?page=2").when().get()
                .then().extract().response().asString();

        return response;

    }


//    @Test
    public void validation_1()
    {
        String res = getStringResponse();
        System.out.println(res);
        JsonPath js = new JsonPath(res);
        String er = js.get("data[2].last_name");
        System.out.println("From String Response:- " + er);

        JsonPath js1 = getRespose().jsonPath();
        String cal = js1.get("data[2].last_name");

        System.out.println(cal);

    }

    @Test
    public void validation_2()
    {
        String res = getStringResponse();
        System.out.println(res);
        JsonPath js = new JsonPath(res);
        Object j = js.getString("data");
        System.out.println(j);
        for(Object obj : js.getList("data"))
        {
//            System.out.println(((LinkedHashMap) obj).get("email"));
            if(((LinkedHashMap) obj).get("first_name").equals("Emma"))
            {
                System.out.println(((LinkedHashMap) obj).get("last_name"));
            }
        }


    }
}
