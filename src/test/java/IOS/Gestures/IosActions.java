package IOS.Gestures;

import Utils.AppiumUtils;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;

public class IosActions extends AppiumUtils {
    protected IOSDriver driver;

    public IosActions(IOSDriver driver) {
        this.driver = driver;
    }

    public void longPressAction(WebElement element, int duration){
        Map<String, Object> params = new HashMap<>();
        params.put("element", element);  // ((RemoteWebElement)incrementButton).getId()
        params.put("duration", duration);
        driver.executeScript("mobile:touchAndHold", params);
    }

    public void scrollAction(WebElement element) {

        // Scroll to the element
        Map<String, Object> params = new HashMap<>();
        params.put("element", element);  //((RemoteWebElement)webViewButton).getId()
        params.put("direction", "down");

        driver.executeScript("mobile:scroll", params);

        // Slide from 0 to 100%
        /**WebElement slider = driver.findElement(AppiumBy.accessibilityId("Slider"));
         slider.sendKeys("0"); // -> move to 0%
         slider.sendKeys("1%"); // -> move t0 100%*/
    }

    public void swipeAction(String direction){
        Map<String,String> swipe = new HashMap<>();
        swipe.put("direction", direction);
        //swipe.put("elementId", WebElement);  -->>> if we need to swipe from some element
        driver.executeScript("mobile:swipe", swipe);  // ((RemoteWebElement)incrementButton).getId()

    }

    public void openAnotherApp(String bundleIdOfApp){
      //  Open another app
        Map<String, String> params = new HashMap<>();
        params.put("bundleId", bundleIdOfApp);  //"com.apple.mobileslideshow"
        driver.executeScript("mobile:launchApp", params);
    }
}
