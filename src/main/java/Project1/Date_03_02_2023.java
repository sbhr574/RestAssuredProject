package Project1;

import io.restassured.path.json.JsonPath;

public class Date_03_02_2023
{
    public static void main(String[] args)
    {
        //Index 2
        JsonPath js = new JsonPath(JsonPayload.date_03022023(2));

        String str = js.getString("Ford");
        System.out.println(str);

        System.out.println(js.getString("cars.Nissan[2]"));
        System.out.println(js.getInt("cars.Nissan.size()"));

        for(int i=0; i<js.getInt("cars.Nissan.size()"); i++)
        {
            System.out.println(js.getString("cars.Nissan["+i+"].model") +" = "+js.getInt("cars.Nissan["+i+"].doors"));
        }

        //Index 1
        js = new JsonPath(JsonPayload.date_03022023(1));
        System.out.println(js.getString("cars.Nissan.Sentra.doors"));


    }
}
