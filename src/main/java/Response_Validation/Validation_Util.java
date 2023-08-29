package Response_Validation;

import io.restassured.path.json.JsonPath;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 *
 * getValueCount - It didn't work
 *
 *
 *
 */
public class Validation_Util
{
    public static void parseObject(JSONObject json, String key)
    {
        System.out.println("Is key available: "+json.has(key));
        if(json.has(key))
        {
            System.out.println("Key '%s' has value: ".formatted(key) +json.get(key));
        }
    }

    /**
     *
     * @param jsResp
     * @param value
     * @param key
     * @return
     */
    public static boolean isValueAvailableOnJsonObject(String jsResp, String key, String value)
    {

        JSONObject json = new JSONObject(jsResp);
        if(json.has(key))
        {
            if(json.get(key) instanceof JSONObject)
            {
                JSONObject innerJson = json.getJSONObject(key);
                Iterator<?> keys;
                String nextKeys;
                keys = innerJson.keys();
                while (keys.hasNext())
                {
                    nextKeys = (String) keys.next();
                    if(nextKeys.equals(value))
                        return true;
                }
            }

        }

        return false;
    }
    public static int getValueCount(JSONObject json, String key, String value)
    {
        int count = 0;
        boolean exists = json.has(key);
        Iterator<?> keys;
        String nextKeys;

        if(!exists)
        {
            keys = json.keys();
            outer:
            while (keys.hasNext())
            {
                nextKeys = (String) keys.next();
                if(json.get(nextKeys) instanceof JSONObject)
                {
                    if(!exists)
                    {
                        count = getValueCount(json.getJSONObject(nextKeys), key, value) > 0 ? count+1 : count;
                    }
                } else if (json.get(nextKeys) instanceof JSONArray)
                {
                    JSONArray innerArray = json.getJSONArray(nextKeys);
                    for(int i=0; i<innerArray.length(); i++)
                    {
                        String jsObj = innerArray.get(i).toString();
                        JSONObject js = new JSONObject(jsObj);

                        if(js.get(key).equals(value))
                        {
                            count++;
//                            break outer;
                        }

                        if(!exists)
                        {
                            count = getValueCount(js, key, value) > 0 ? count+1 : count;
                        }
                    }
                }
            }
        }
        else
        {
            if(json.has(key))
            {
                if(json.get(key).equals(value))
                {
                    count++;
                }
            }
        }

        return count;
    }
    public static void getKey(JSONObject json, String key)
    {
        boolean exists = json.has(key);
        Iterator<?> keys;
        String nextKeys;

        if(!exists)
        {
            keys = json.keys();
            outer:
            while (keys.hasNext())
            {
                nextKeys = (String) keys.next();
                if(json.get(nextKeys) instanceof JSONObject)
                {
                    if(!exists)
                    {
                        getKey(json.getJSONObject(nextKeys), key);
                    }
                } else if (json.get(nextKeys) instanceof JSONArray)
                {
                    JSONArray innerArray = json.getJSONArray(nextKeys);
                    for(int i=0; i<innerArray.length(); i++)
                    {
                        String jsObj = innerArray.get(i).toString();
                        JSONObject js = new JSONObject(jsObj);

                        if(!exists)
                        {
                            getKey(js, key);
                        }
                    }
                }
            }
        }
        else
        {
            parseObject(json, key);
        }

    }

    public static void main(String[] args) {
        String str = "{\n" +
                "    \"page\": 1,\n" +
                "    \"per_page\": 6,\n" +
                "    \"total\": 12,\n" +
                "    \"total_pages\": 2,\n" +
                "    \"data\": [\n" +
                "        {\n" +
                "            \"id\": 1,\n" +
                "            \"email\": \"george.bluth@reqres.in\",\n" +
                "            \"first_name\": \"George\",\n" +
                "            \"last_name\": \"Bluth\",\n" +
                "            \"avatar\": \"https://reqres.in/img/faces/1-image.jpg\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 2,\n" +
                "            \"email\": \"janet.weaver@reqres.in\",\n" +
                "            \"first_name\": \"Janet\",\n" +
                "            \"last_name\": \"Weaver\",\n" +
                "            \"avatar\": \"https://reqres.in/img/faces/2-image.jpg\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 3,\n" +
                "            \"email\": \"emma.wong@reqres.in\",\n" +
                "            \"first_name\": \"Emma\",\n" +
                "            \"last_name\": \"Wong\",\n" +
                "            \"avatar\": \"https://reqres.in/img/faces/3-image.jpg\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 4,\n" +
                "            \"email\": \"eve.holt@reqres.in\",\n" +
                "            \"first_name\": \"Eve\",\n" +
                "            \"last_name\": \"Holt\",\n" +
                "            \"avatar\": \"https://reqres.in/img/faces/4-image.jpg\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 5,\n" +
                "            \"email\": \"charles.morris@reqres.in\",\n" +
                "            \"first_name\": \"Charles\",\n" +
                "            \"last_name\": \"Morris\",\n" +
                "            \"avatar\": \"https://reqres.in/img/faces/5-image.jpg\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 6,\n" +
                "            \"email\": \"tracey.ramos@reqres.in\",\n" +
                "            \"first_name\": \"Tracey\",\n" +
                "            \"last_name\": \"Ramos\",\n" +
                "            \"avatar\": \"https://reqres.in/img/faces/6-image.jpg\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"support\": {\n" +
                "        \"url\": \"https://reqres.in/#support-heading\",\n" +
                "        \"text\": \"To keep ReqRes free, contributions towards server costs are appreciated!\",\n" +
                "        \"first_name\": \"Tracey\"\n" +
                "    }\n" +
                "}";


        JSONObject js = new JSONObject(str);

//        System.out.println(js.has("data"));
//
//        System.out.println(getValueCount(js, "first_name", "Tracey"));
//
//        getKey(js, "first_name");

        System.out.println(isValueAvailableOnJsonObject(str, "support", "first_name"));
        System.out.println(isValueAvailableOnJsonObject(str, "data", "Tracey"));
    }
}
