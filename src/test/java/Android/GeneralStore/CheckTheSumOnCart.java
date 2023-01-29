package Android.GeneralStore;

import Android.AndroidActions.AndroidActions;
import Configurations.BaseTest;
import PageObjectsAndroid.FormPage;
import PageObjectsAndroid.ProductCatalog;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class checkTheSum extends BaseTest {
    AndroidActions androidActions = new AndroidActions(driver);
    GeneralCommands generalCommands = new GeneralCommands();
    FormPage formPage = new FormPage(driver);
    ProductCatalog productCatalog = new ProductCatalog(driver);
    @Test
    public void checkTheSum() throws InterruptedException {

        formPage.authorization();

        productCatalog.selectTwoItems();
        productCatalog.navigateToCart();

        Assert.assertEquals(productCatalog.getSumOfOrderItems(), productCatalog.getTotalScreenAmount(), "The sums should be the same");

        productCatalog.
        androidActions.longPressAction(driver.findElement(By.id("com.androidsample.generalstore:id/termsButton")));

        Assert.assertEquals(driver.findElement(By.id("com.androidsample.generalstore:id/alertTitle")).getText(),
                                                    "Terms Of Conditions");
        driver.findElement(By.id("android:id/button1")).click();
        driver.findElement(By.xpath("//android.widget.CheckBox")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
        Thread.sleep(16000);

    }

}




