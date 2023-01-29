package Configurations;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class BaseTest {
    protected static AndroidDriver driver;
    protected static AppiumDriverLocalService serviceBuilder;



    @BeforeTest
    public static void startDriver(){
        driver = CreateDrivers.selectAndroidDriver(Drivers.CHROME);
    }


    @AfterTest
    public void tearDown(){
        if(driver !=null) {
            driver.quit();
            serviceBuilder.stop();
        }
    }
}
