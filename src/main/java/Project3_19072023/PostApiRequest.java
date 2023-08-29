package Project3_19072023;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import net.minidev.json.JSONObject;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PostApiRequest
{
    @BeforeMethod
    public void logFailedApiTest()
    {
        //If api request fails it going to print the log on console
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
    @Test
    public void createBooking()
    {
        JSONObject booking = new JSONObject();
        JSONObject bookingDates = new JSONObject();

        booking.put("firstname", "Subhajit");
        booking.put("lastname", "Roy");
        booking.put("totalprice", 111);
        booking.put("depositpaid", true);
        booking.put("bookingdates", bookingDates);
        booking.put("additionalneeds", "Breakfast");

        bookingDates.put("checkin", "2018-01-01");
        bookingDates.put("checkout", "2018-01-02");

        RestAssured.given().contentType(ContentType.JSON).body(booking.toString()).baseUri("https://restful-booker.herokuapp.com/booking").when()
                .post().then().assertThat().log().all().statusCode(200).body("booking.firstname", Matchers.equalTo("Subhajit"));

    }


}
