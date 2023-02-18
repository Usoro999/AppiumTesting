package IOS.PageObjects;

import IOS.Gestures.IosActions;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class HomePage extends IosActions {
    IOSDriver driver;

    public HomePage(IOSDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @iOSXCUITFindBy(accessibility = "Alert Views")
    WebElement alertViewsBtn;
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Steppers\"")
    WebElement steppersBtn;



    public void clickAlertViewsBtn(){
        alertViewsBtn.click();
    }


    public void clickSteppersBtn() {
        steppersBtn.click();

    }
}
