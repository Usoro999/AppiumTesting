package Ios;

import Configurations.IosBaseTest;
import io.appium.java_client.AppiumBy;
import org.checkerframework.checker.units.qual.A;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IosBasicTest extends IosBaseTest {

    @Test
    public void simpleTest(){
        driver.findElement(AppiumBy.accessibilityId("Alert Views")).click();
        // iosChainClass selector
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == 'Text Entry'`]")).click();
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeCell")).sendKeys("Hello World");
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`label == 'OK'`]")).click();
        // predicateString
        driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value =='Confirm / Cancel'"));
        driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value BEGINSWITH 'Confirm'")).click();
        driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value ENDSWITH 'Cancel'"));
        String message = driver.findElement(AppiumBy.iOSNsPredicateString("value BEGINSWITH 'A message'")).getText();
        Assert.assertEquals(message, "A message should be a short, complete sentence.");
        driver.findElement(AppiumBy.iOSNsPredicateString("label == \"Confirm\"")).click();



    }

}
