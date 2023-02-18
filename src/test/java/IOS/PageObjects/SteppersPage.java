package IOS.PageObjects;

import IOS.Gestures.IosActions;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class SteppersPage extends IosActions {
    IOSDriver driver;

    public SteppersPage(IOSDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
   @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Increment\"`][3]")
   WebElement incrementBtn;
    public void longPressOnIncrementBtn(){
        longPressAction(incrementBtn, 2);
    }


}
