package Android.GeneralStore;

import Android.Configurations.AndroidBaseTest;
import Android.PageObjectsAndroid.FormPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CheckErrorToastTest extends AndroidBaseTest {
    FormPage formPage = new FormPage(driver);

    @Test
    public void checkToastMessageTest() throws InterruptedException {
        formPage = new FormPage(driver);
        formPage.authorization("", "Argentina");

        Assert.assertEquals(formPage.getToastMessageText(), "Please enter your name");
    }


}
