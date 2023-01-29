package Android.GeneralStore;

import Configurations.BaseTest;
import Android.PageObjectsAndroid.CartPage;
import Android.PageObjectsAndroid.FormPage;
import Android.PageObjectsAndroid.GeneralCommands;
import Android.PageObjectsAndroid.ProductCatalog;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import java.util.Set;


public class SwitchTheApp extends BaseTest {
    GeneralCommands generalCommands = new GeneralCommands();
    FormPage formPage = new FormPage(driver);
    ProductCatalog productCatalog = new ProductCatalog(driver);
    CartPage cartPage = new CartPage(driver);

    @Test
    public void switchTheApp() throws InterruptedException {

        formPage.authorization();

        productCatalog.selectTwoItems();
        productCatalog.navigateToCart();
        cartPage.finishOrder();
        Thread.sleep(5000);








    // The app is changed to the internet app
    // if you don't know the context of the app -> make Set of all contexts
        Set<String> contexts = driver.getContextHandles();
            for (String context:contexts) {
                System.out.println(context);
                // ["NATIVE_APP","WEBVIEW_com.androidsample.generalstore"]
            }
    // Switch to the internet app
        driver.context("WEBVIEW_com.androidsample.generalstore");
        driver.findElement(By.name("q")).sendKeys("Automation");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

    // If you want to get back to the Native app
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.context("NATIVE_APP");
    }

}




