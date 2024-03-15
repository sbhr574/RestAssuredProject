package Project4_15032024;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.codec.binary.Base64;


public class PassBasicAuth
{
    public void passBasicAuth()
    {
        RestAssured.baseURI = "";
        RequestSpecification request = RestAssured.given();

        String pat_ADO = "hdhnd73763@neduen#ndndi8eie8eke9ejd82w93";

        byte[] encodedPat = Base64.encodeBase64(pat_ADO.getBytes());
        String encodedPatAsString = new String(encodedPat);

        request.header("Authorization","Basic " +encodedPatAsString);
        request.when().post();
    }
}
