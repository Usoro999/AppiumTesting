package IOS.PageObjects;

import IOS.Gestures.IosActions;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

import static io.appium.java_client.MobileBy.iOSClassChain;

public class PhotosAppPage extends IosActions {
    IOSDriver driver;

    public PhotosAppPage(IOSDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"All Photos\"`]")
    WebElement allPhotosBtn;

    public void clickAllPhotosBtn(){
        allPhotosBtn.click();
    }
    public void swipeAllPhotos(){

        List<WebElement> photos = driver.findElements(AppiumBy.iOSClassChain("**/XCUIElementTypeCell"));

        photos.get(1).click();
        for(int i = 1; i < photos.size(); i++) {
            swipeAction("left");
        }
    }


}
