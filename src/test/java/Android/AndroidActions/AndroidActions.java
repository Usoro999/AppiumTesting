package Android.AndroidActions;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

public class AndroidActions {
    AndroidDriver driver;

    public AndroidActions(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void scrollToText(String text){

        driver.findElement(AppiumBy
                .androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text('" + text + "'));"));
    }

    public void scrollToPosition(String left, String top, String width, String height, String direction, double percent){
         boolean canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                "left", left, "top", top, "width", width, "height", height,
                "direction", direction,
                "percent", percent
        ));
    }

    public void swipeAction(WebElement element, String direction, double percent){
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", element,  // ((RemoteWebElement) element ).getId()
                "direction", "direction",
                "percent", percent  // should be from 0.0 to 1.0 (ex. 0.75)
        ));


    }
    public void dragAndDrop(WebElement element){
        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element ).getId(),
                "endX",620,
                "endY", 550
        ));

    }

    public void longPressAction(WebElement element) {

        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
                ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "duration", 2000));
    }
    public void hideKeyboard() {
        driver.hideKeyboard();
}

    public void rotateScreen(){
        DeviceRotation deviceRotation =new DeviceRotation(0,0,90);
        driver.rotate(deviceRotation);
    }

    public void copyToClipBoard(WebElement element){
        driver.setClipboardText(element.getText());
    }
    public void pastFromClipboard(WebElement element){
        element.sendKeys(driver.getClipboardText());
    }

    public void miscellaneous(){

        //Main mobile Keys
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.pressKey(new KeyEvent(AndroidKey.HOME));

        // if we want to start the program from specific place
        // command in terminal:
        // adb shell dumpsys window | grep -E 'mCurrentFocus'  === find out the packageName and ActivityName
        Activity activity = new Activity("io.appium.android.apis","io.appium.android.apis.view.RotatingButton");
        driver.startActivity(activity);
    }


}
