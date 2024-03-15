package Yahtzee;

public class Payload
{
    public static String addPlayer()
    {
        return "name: 'foo'";
    }

    public static String setDie()
    {
        return "{\n" +
                "  \"id\": 1,\n" +
                "  \"value\": 5\n" +
                "}";
    }

    public static String rollDie()
    {
        return "summary: Roll all five dice\n" +
                "      description: Rolls all five dice and returns their new values. Returns all five dice.";
    }
}
