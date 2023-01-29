package Android.GeneralStore;

import Configurations.BaseTest;
import Android.PageObjectsAndroid.FormPage;
import org.testng.annotations.Test;


public class FillForm extends BaseTest {
    FormPage formPage = new FormPage(driver);

    @Test
    public void fillForm() throws InterruptedException {
        formPage.selectCountry("Argentina");
        formPage.fillNameField("Soro");
        formPage.clickBtnLetsShop();
        
        Thread.sleep(5000);
    }
}
