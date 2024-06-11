package Android.GeneralStore;

import Android.Configurations.AndroidBaseTest;
import Android.PageObjectsAndroid.CartPage;
import Android.PageObjectsAndroid.FormPage;
import Android.PageObjectsAndroid.ProductCatalog;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import java.util.Set;


public class SwitchTheAppTest extends AndroidBaseTest {
    FormPage formPage;
    ProductCatalog productCatalog;
    CartPage cartPage;

    @Test
    public void switchTheApp() throws InterruptedException {
        cartPage = new CartPage(driver);
        formPage = new FormPage(driver);
        productCatalog  = new ProductCatalog(driver);


        formPage.authorization("Soro", "Argentina");

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




