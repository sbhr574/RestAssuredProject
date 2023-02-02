package Project1;

public class JsonPayload
{
    public static String purchaseAmount()
    {
        return "{\n" +
                "\n" +
                "\"dashboard\": {\n" +
                "\n" +
                "\"purchaseAmount\": 910,\n" +
                "\n" +
                "\"website\": \"rahulshettyacademy.com\"\n" +
                "\n" +
                "},\n" +
                "\n" +
                "\"courses\": [\n" +
                "\n" +
                "{\n" +
                "\n" +
                "\"title\": \"Selenium Python\",\n" +
                "\n" +
                "\"price\": 50,\n" +
                "\n" +
                "\"copies\": 6\n" +
                "\n" +
                "},\n" +
                "\n" +
                "{\n" +
                "\n" +
                "\"title\": \"Cypress\",\n" +
                "\n" +
                "\"price\": 40,\n" +
                "\n" +
                "\"copies\": 4\n" +
                "\n" +
                "},\n" +
                "\n" +
                "{\n" +
                "\n" +
                "\"title\": \"RPA\",\n" +
                "\n" +
                "\"price\": 45,\n" +
                "\n" +
                "\"copies\": 10\n" +
                "\n" +
                "}\n" +
                "\n" +
                "]\n" +
                "\n" +
                "}";
    }

    public static String AddPlace()

    {
        return "{\r\n" +
                "  \"location\": {\r\n" +
                "    \"lat\": -38.383494,\r\n" +
                "    \"lng\": 33.427362\r\n" +
                "  },\r\n" +
                "  \"accuracy\": 50,\r\n" +
                "  \"name\": \"Rahul Shetty Academy\",\r\n" +
                "  \"phone_number\": \"(+91) 983 893 3937\",\r\n" +
                "  \"address\": \"29, side layout, cohen 09\",\r\n" +
                "  \"types\": [\r\n" +
                "    \"shoe park\",\r\n" +
                "    \"shop\"\r\n" +
                "  ],\r\n" +
                "  \"website\": \"http://rahulshettyacademy.com\",\r\n" +
                "  \"language\": \"French-IN\"\r\n" +
                "}\r\n" +
                "";
    }

    public static String addDynamicJson(String testNo, String testId)

    {
        return "{\r\n" +
                "  \"location\": {\r\n" +
                "    \"lat\": -38.383494,\r\n" +
                "    \"lng\": 33.427362\r\n" +
                "  },\r\n" +
                "  \"accuracy\": 50,\r\n" +
                "  \"name\": \"Rahul Shetty Academy\",\r\n" +
                "  \"phone_number\": \"(+91) 983 893 3937\",\r\n" +
                "  \"Testid\": \"" + testNo + "\",\r\n" +
                "  \"Id\": \"" + testId + "\",\r\n" +
                "  \"types\": [\r\n" +
                "    \"shoe park\",\r\n" +
                "    \"shop\"\r\n" +
                "  ],\r\n" +
                "  \"website\": \"http://rahulshettyacademy.com\",\r\n" +
                "  \"language\": \"French-IN\"\r\n" +
                "}\r\n" +
                "";
    }

    public static String date_03022023(int index)
    {
        return switch(index)
                {
                    case 1 -> "{\n" +
                                "    \"cars\": {\n" +
                                "        \"Nissan\": {\n" +
                                "            \"Sentra\": {\"doors\":4, \"transmission\":\"automatic\"},\n" +
                                "            \"Maxima\": {\"doors\":4, \"transmission\":\"automatic\"}\n" +
                                "        },\n" +
                                "        \"Ford\": {\n" +
                                "            \"Taurus\": {\"doors\":4, \"transmission\":\"automatic\"},\n" +
                                "            \"Escort\": {\"doors\":4, \"transmission\":\"automatic\"}\n" +
                                "        }\n" +
                                "    }\n" +
                                "}";

                    case 2 -> "{\n" +
                            "    \"cars\": {\n" +
                            "        \"Nissan\": [\n" +
                            "            {\"model\":\"Sentra\", \"doors\":4},\n" +
                            "            {\"model\":\"Maxima\", \"doors\":4},\n" +
                            "            {\"model\":\"Skyline\", \"doors\":2}\n" +
                            "        ],\n" +
                            "        \"Ford\": [\n" +
                            "            {\"model\":\"Taurus\", \"doors\":4},\n" +
                            "            {\"model\":\"Escort\", \"doors\":4}\n" +
                            "        ]\n" +
                            "    }\n" +
                            "}";

                    default -> throw new IllegalStateException("Unexpected value: " + index);
                };
    }
}
