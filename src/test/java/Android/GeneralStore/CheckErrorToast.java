package Android.GeneralStore;

import Configurations.BaseTest;
import Android.PageObjectsAndroid.FormPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CheckErrorToast extends BaseTest {
    FormPage formPage = new FormPage(driver);
    @Test
    public void checkToastMessage() throws InterruptedException {

        formPage.authorization();

        Assert.assertEquals(formPage.getToastMessageText(), "Please enter your name");
    }


}
