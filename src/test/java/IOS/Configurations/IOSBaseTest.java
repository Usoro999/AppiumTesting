package IOS.Configurations;

import Utils.AppiumUtils;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.annotations.*;

import java.io.IOException;


public class IOSBaseTest extends AppiumUtils {
    protected static IOSDriver driver;



    @BeforeMethod
    public void startDriver() throws IOException {
        driver = CreateIOSDrivers.selectIOSDriver(Drivers.IOSDRIVER);
    }


    @AfterMethod
    public void tearDown(){

            driver.quit();
            serviceBuilder.stop();

    }
}
