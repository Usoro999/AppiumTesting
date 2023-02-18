package IOS.PageObjects;

import IOS.Gestures.IosActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumElementLocatorFactory;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class AlertViewsPage extends IosActions {
    IOSDriver driver;

    public AlertViewsPage(IOSDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'Text Entry'`]")
    WebElement textEntryBtn;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell")
    WebElement textField;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'OK'`]")
    WebElement textEntryOKbtn;
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND value BEGINSWITH 'Confirm'")
    WebElement confirmCancelBtn;
    @iOSXCUITFindBy(iOSNsPredicate = "value BEGINSWITH 'A message'")
    WebElement messageText;
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Confirm\"")
    WebElement confirmBtn;

    public void clickTextEntry() {
        textEntryBtn.click();
    }

    public void sendTextToTextEntry(String text) {
        textField.sendKeys(text);
    }

    public void clickTextEntryOK() {
        textEntryOKbtn.click();
    }

    public void clickConfirmCancelBtn() {
        // Operators
        driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value =='Confirm / Cancel'"));
        driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value ENDSWITH 'Cancel'"));
        confirmCancelBtn.click();
    }

    public String getMessageText(){
        return messageText.getText();
    }
    public void clickConfirmBtn(){
        confirmBtn.click();
    }
}
