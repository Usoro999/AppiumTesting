package Ios;

import Configurations.IosBaseTest;
import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

public class IosTest extends IosBaseTest {

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
        driver.findElement(AppiumBy.iOSNsPredicateString("label == \"Confirm\"")).click();


    }

}
