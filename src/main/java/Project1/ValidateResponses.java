package Project1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidateResponses
{

    @Test
    public void PostResponse()
    {

        new Update_Address().updatePlace();

    }

    @Test
    public void ValidateAddress()
    {
        new Update_Address().updatePlace();
        Assert.assertEquals(new GetUpdatedAddress().getAddress(), "Kaliyaganj, India");
    }
}
