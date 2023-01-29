package Ios.Gestures;

import Configurations.IosBaseTest;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IOSSwipe extends IosBaseTest {

    @Test
    public void swipeTest(){

        //How to open a native app on the ios
        // Android 'appPackage' == Ios 'Bundle ID'.
        // Navigate to Apple to find Bundle id from 'Photos'

//        Open another app
        Map<String, String> params = new HashMap<>();
        params.put("bundleId", "com.apple.mobileslideshow");  // ((RemoteWebElement)incrementButton).getId()

        driver.executeScript("mobile:launchApp", params);
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`label == \"All Photos\"`]")).click();
        List<WebElement> photos = driver.findElements(AppiumBy.iOSNsPredicateString("XCUIElementTypeImage"));

        photos.get(0).click();


        Map<String,String> swipe = new HashMap<>();
        swipe.put("direction", "left");
        //swipe.put("elementId", WebElement);  -->>> if we need to swipe from some element
        driver.executeScript("mobile:swipe", swipe);


    }
}
