package AndroidGeneralStore;

import Configurations.BaseTest;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CheckErrorToast extends BaseTest {
    // how to install any app to emulator
    //adb install /Users/yurii/MyFiles/JavaProjects/ATest/src/test/resources/General-Store.apk
    @Test
    public void fillFormWithInvalidData() throws InterruptedException {

        driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
        driver.findElement(By.xpath("//android.widget.TextView[@text = 'Argentina']")).click();

        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

        //Catch error toast text
        // using xpath and "//android.widget.Toast" and non-shown attribute "name"
        String toastText = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");

        Assert.assertEquals(toastText, "Please enter your name");

    }
}
