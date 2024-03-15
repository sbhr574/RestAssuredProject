package Yahtzee;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestCase1
{
    public static Response getResponse()
    {
        RestAssured.baseURI = "http://localhost:8080/playerName";
        String response = "not Found";

        try
        {
           return given().header("Content-Type","application/json").when().get().then().log().all().assertThat().statusCode(200)
                    .extract().response();
        }
        catch (Exception e)
        {
            System.out.println("Unexpected Error %s".formatted(e));
        }

        return null;
    }


    public static Response dynamicEndPoints(String endpoint)
    {
//        RestAssured.baseURI = "https://url/";
//        String response = "not Found";
//
//        try
//        {
//            return given().request(endpoint).when().get().then().log().all().assertThat().statusCode(200)
//                    .extract().response();
//        }
//        catch (Exception e)
//        {
//            System.out.println("Unexpected Error %s".formatted(e));
//        }

        return null;
    }



    @Test
    public void responseValidation_TC1(String val)
    {
        JSONObject json = new JSONObject(val);
        val = getResponse().asString();
        Assert.assertEquals(true, ValidationUtil.isValueAvailableOnJsonObject(val, "status", "success"));
        Assert.assertEquals(true, ValidationUtil.isValueAvailableOnJsonObject(val, "data", "foo"));
    }

    public static String testCase2()
    {
        RestAssured.baseURI = "https://url/playerName";
        String response = "not Found";


        try
        {
            Response resp = given().header("Content-Type","application/json").body(Payload.addPlayer())
                    .when().put();

            int code = resp.statusCode();

            String val = switch (code)
            {
                case 204 :
                    System.out.println("Name");
                            yield "Name";

                case 400 :
                    System.out.println("Bad request");
                    yield "Bad request";

                case 401 :
                    System.out.println("Unauthorized");
                    yield "Unauthorized";

                default:
                    throw new IllegalStateException("Unexpected value: " + code);
            };

            response = resp.then().extract().asString();

        }
        catch (Exception e)
        {
            System.out.println("Unexpected Error %s".formatted(e));
        }

        return response;
    }

    @Test
    public void responseValidation_TC2(String val)
    {
        JSONObject json = new JSONObject(val);
        val = testCase2();
        Assert.assertEquals(true, ValidationUtil.isValueAvailableOnJsonObject(val, "status", "failed"));
        Assert.assertEquals(true, ValidationUtil.isValueAvailableOnJsonObject(val, "data", "This is why your request failed"));
    }
    public static String testCase3()
    {
        RestAssured.baseURI = "https://url/die";
        String response = "not Found";

        try
        {
            response = given().queryParam("key", "12").header("Content-Type","application/json")
                    .when().get().then().log().all().assertThat().statusCode(200)
                    .extract().response().body().asString();
        }
        catch (Exception e)
        {
            System.out.println("Unexpected Error %s".formatted(e));
        }

        return response;
    }

    public static String testCase4()
    {
        RestAssured.baseURI = "https://url/die";
        String response = "not Found";

        try
        {
            Response resp = given().header("Content-Type","application/json").body(Payload.setDie())
                    .when().put();

            int statusCode = resp.statusCode();

            response = resp.asString();

            String getResp =
                    switch (statusCode)
                            {
                                case 204:
                                    yield "Die set successfully";
                                case 400:
                                    yield "Bad Request";

                                case 401:
                                    yield "Unauthorized";

                                default:
                                    throw new IllegalStateException("Unexpected value: " + statusCode);
                            };

            validation_test4(getResp, response);
        }
        catch (Exception e)
        {
            System.out.println("Unexpected Error %s".formatted(e));
        }



        return response;
    }

    public static void validation_test4(String status, String response)
    {
        if(status.equals("Die set successfully"))
        {
            System.out.println("");
        } else if (status.equals("Bad Request"))
        {
            Assert.assertEquals(true, ValidationUtil.isValueAvailableOnJsonObject(response, "status", "This is why your req failed"));
        } else if (status.equals("Unauthorized"))
        {
            Assert.assertEquals(true, ValidationUtil.isValueAvailableOnJsonObject(response, "status", "This is why your req failed"));
        }

    }

    public static String testCase5()
    {
        RestAssured.baseURI = "https://url/rollDie/";
        String response = "not Found";

        try
        {
            response = given().queryParam("key", "12").header("Content-Type","application/json").body(Payload.rollDie())
                    .when().post().then().log().all().assertThat().statusCode(200)
                    .extract().response().asString();
        }
        catch (Exception e)
        {
            System.out.println("Unexpected Error %s".formatted(e));
        }

        return response;
    }

    public static String testCase6()
    {
        RestAssured.baseURI = "https://url/rollDie/";
        String response = "not Found";

        try
        {
            response = given().queryParam("key", "12").header("Content-Type","application/json").body(Payload.rollDie())
                    .when().post().then().log().all().assertThat().statusCode(200)
                    .extract().response().asString();



        }
        catch (Exception e)
        {
            System.out.println("Unexpected Error %s".formatted(e));
        }

        return response;
    }


}
