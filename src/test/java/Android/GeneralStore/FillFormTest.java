package Android.GeneralStore;

import Android.Configurations.AndroidBaseTest;
import Android.DataProviderClass.DataProviderClass;
import Android.PageObjectsAndroid.FormPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;


public class FillFormTest extends AndroidBaseTest {
    FormPage formPage;

   //@BeforeMethod
    public void preStart() throws InterruptedException {
//         Start each method from the same page
        formPage = new FormPage(driver);
        formPage.setActivity();

    }

    @Test(dataProvider = "userData", dataProviderClass = DataProviderClass.class)
    public void fillFormTestWithPositiveData(String name, String country) throws InterruptedException {
        formPage = new FormPage(driver);
        formPage.authorization(name, country);

    }

    @Test(dataProvider = "invalidUserData", dataProviderClass = DataProviderClass.class)
    public void fillFormTestWithInvalidData(String name, String country) throws InterruptedException {
        formPage = new FormPage(driver);
        formPage.authorization(name, country);

        Assert.assertEquals(formPage.getToastMessageText(), "Please enter your name");
    }

    @Test(dataProvider = "getDataFromJson", dataProviderClass = DataProviderClass.class)
    public void fillFormTestWithJson(HashMap<String, String> data) throws InterruptedException {
        formPage = new FormPage(driver);
        formPage.authorization(data.get("name"), data.get("country"));
    }
}