package Response_Validation;

public class Status_Code_Validation
{
    private static String status_validation(int code)
    {
        return switch (code)
                {
                    case 204 :
                        System.out.println("Name");
                        yield "Name";

                    case 400 :
                        System.out.println("Bad request");
                        yield "Bad request";

                    case 401 :
                        System.out.println("Unauthorized");
                        yield "Unauthorized";

                    default:
                        throw new IllegalStateException("Unexpected value: " + code);
                };

    }
}
