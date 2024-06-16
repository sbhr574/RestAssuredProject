package Project5_06062024;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

/**
 * How many way we can read JSON file
 * 1) Jackson library
 * 2) Gson library
 * 3) json-simple library
 */
public class Ways_to_read_data_from_JSON
{
    /**
     * a) need to add "json-simple" maven dependency
     * b)JSONObject will import from org.json.simple.JSONObject
     *
     * @throws IOException
     * @throws ParseException
     */
    public void way1() throws IOException, ParseException {
        String path = "C:\\Users\\subha\\Desktop\\RestAssuredProject\\src\\main\\resources\\InVivo.json";
        JSONParser parser = new JSONParser();
        FileReader reader = new FileReader(path);
        Object obj = parser.parse(reader);
        JSONObject jsonObject = (JSONObject)obj;
        String val = (String) jsonObject.get("worksheetMetaData").toString();
        System.out.println(val);
    }

    public static void main(String[] args) throws IOException, ParseException {
//        JSONObject js = new JSONObject("C:\\Users\\subha\\Desktop\\RestAssuredProject\\src\\main\\resources\\InVivo.json");
//        System.out.println(js.toString().contains("worksheetMetaData"));

    }
}
