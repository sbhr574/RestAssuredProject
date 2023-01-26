package Project1;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DynamicJson
{
    /**
     *
     * How to use testNg dataProvider to use dynamic data
     */
    @DataProvider(name = "TestID")
    public Object[][] dynamicItems()
    {
        return new Object[][] {{"Test1", "54"}, {"Test2", "76"}, {"Test3", "90"}};
    }
    @Test(dataProvider = "dynamicItems")
    public void add(String testNum, String testId)
    {
        RestAssured.baseURI = "";

        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.body(JsonPayload.addDynamicJson(testNum, testId))
                .when().log().all().post("").asString();
    }
}
