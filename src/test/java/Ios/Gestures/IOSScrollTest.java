package Ios.Gestures;

import Configurations.IosBaseTest;
import io.appium.java_client.AppiumBy;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class IOSScrollTest extends IosBaseTest {

    @Test
    public void iosScroll() throws InterruptedException {

        // Scroll to the element
        WebElement webViewButton = driver.findElement(AppiumBy.accessibilityId("Web View"));
        Map<String, Object> params = new HashMap<>();
        params.put("element", webViewButton);  //((RemoteWebElement)webViewButton).getId()
        params.put("direction", "down");

        driver.executeScript("mobile:scroll", params);
        webViewButton.click();
        Thread.sleep(2000);

        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`label == \"UIKitCatalog\"`]")).click();

        //Picker menu -> use sendKeys()
        driver.findElement(AppiumBy.accessibilityId("Picker View")).click();
        driver.findElement(AppiumBy.accessibilityId("Red color component value")).sendKeys("100");
        driver.findElement(AppiumBy.accessibilityId("Green color component value")).sendKeys("220");

        // Slide from 0 to 100%
        /**WebElement slider = driver.findElement(AppiumBy.accessibilityId("Slider"));
        slider.sendKeys("0"); // -> move to 0%
        slider.sendKeys("1%"); // -> move t0 100%*/


    }
}
