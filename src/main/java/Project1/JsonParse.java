package Project1;

import io.restassured.path.json.JsonPath;

public class JsonParse
{

    public static void main(String[] args)
    {
        JsonPath js = new JsonPath(JsonPayload.purchaseAmount());
        int sizeOfCourses = js.getInt("courses.size()");
        System.out.println(sizeOfCourses);

        //Parent to child traverse with "." operator
        int amount = js.getInt("dashboard.purchaseAmount");
        System.out.println(amount);

        String titleFirstCourse = js.get("courses[0].title");
        System.out.println(titleFirstCourse);

        getCopyCount("RPA");
        getCopyCount("Cypress");
    }

    //How to get RPA copies count from json payload
    public static void getCopyCount(String courseName)
    {
        JsonPath js = new JsonPath(JsonPayload.purchaseAmount());
        for(int i=0; i < js.getInt("courses.size()"); i++)
        {
            if(js.get("courses["+i+"].title").equals(courseName))
            {
                System.out.println("Total copies of "+courseName+": " + js.get("courses["+i+"].copies"));
                break;
            }
        }
    }
}
