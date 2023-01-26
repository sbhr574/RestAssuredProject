package Project1;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.*;
public class Json_Static_Payload
{
    @Test
    public void addBook() throws IOException 
    {
        RestAssured.baseURI="http://216.10.245.166";
        String currentWorkingDir = System.getProperty("user.dir") + "\\src\\main\\resources\\Add.json";
        Response resp=given().
                header("Content-Type","application/json").
                body(GenerateStringFromResource(currentWorkingDir)).
                when().
                post("/Library/Addbook.php").
                then().assertThat().statusCode(200).
                extract().response();

        JsonPath js= new JsonPath(resp.asString());
        String id=js.get("ID");
        System.out.println(id);
    }

    //Content of the file needed string -> content convert into byte -> byte to string
    public static String GenerateStringFromResource(String path) throws IOException 
    {
        return new String(Files.readAllBytes(Paths.get(path)));
    }
}
