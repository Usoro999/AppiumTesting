package Ios.Gestures;

import Configurations.IosBaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSTouchAction;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class IOSlongPress extends IosBaseTest {

    @Test
    public void longPress(){

        driver.findElement(AppiumBy.iOSNsPredicateString("label == \"Steppers\"")).click();
        WebElement incrementButton = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`label == \"Increment\"`][3]"));

//        LongPress action
        Map<String, Object> params = new HashMap<>();
        params.put("element", incrementButton);  // ((RemoteWebElement)incrementButton).getId()
        params.put("duration", 5);
        driver.executeScript("mobile:touchAndHold", params);

    }
}
