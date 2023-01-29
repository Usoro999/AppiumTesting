package Configurations;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.annotations.*;


public class IosBaseTest {
    protected static IOSDriver driver;
    protected static AppiumDriverLocalService serviceBuilder;



    @BeforeMethod
    public void startDriver(){
        driver = CreateIOSDrivers.selectIOSDriver(Drivers.IOSDRIVER);
    }


    @AfterMethod
    public void tearDown(){
        if(driver !=null) {
            driver.quit();
            serviceBuilder.stop();
        }
    }
}
