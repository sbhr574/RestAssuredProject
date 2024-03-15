package Yahtzee;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Iterator;

public class ValidationUtil
{
    public static void parseObject(JSONObject json, String key)
    {
        System.out.println("Is key available: "+json.has(key));
        if(json.has(key))
        {
            System.out.println("Key '%s' has value: ".formatted(key) +json.get(key));
        }
    }
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
}
