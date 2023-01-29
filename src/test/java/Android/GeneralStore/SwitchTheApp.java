package AndroidGeneralStore;

import Configurations.BaseTest;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;


public class SwitchTheApp extends BaseTest {
    GeneralCommands generalCommands = new GeneralCommands();

    @Test
    public void switchTheApp() throws InterruptedException {

        generalCommands.authorization();

        // We aren't sure how many elements will be shown (3 or 2)
        int amountOfItems = driver.findElements(By.xpath("//android.widget.TextView[@text = 'ADD TO CART']")).size();
        if(amountOfItems == 3) {
            driver.findElements(By.xpath("//android.widget.TextView[@text = 'ADD TO CART']")).get(0).click();
            driver.findElements(By.xpath("//android.widget.TextView[@text = 'ADD TO CART']")).get(1).click();
        }else {
            driver.findElements(By.xpath("//android.widget.TextView[@text = 'ADD TO CART']")).get(0).click();
            driver.findElement(By.xpath("//android.widget.TextView[@text = 'ADD TO CART']")).click();
        }

        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        Thread.sleep(3000);

        //Switching the pages is contained several seconds = necessarily to use Wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")),"text","Cart"));

        driver.findElement(By.xpath("//android.widget.CheckBox")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
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




