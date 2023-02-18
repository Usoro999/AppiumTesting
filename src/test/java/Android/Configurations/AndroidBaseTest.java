package Android.Configurations;

import Utils.AppiumUtils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;

import org.testng.annotations.*;

import java.io.IOException;



public class AndroidBaseTest extends AppiumUtils {
    public static AndroidDriver driver;

    @BeforeClass(alwaysRun = true)
    public void startDriver() throws IOException {
        driver = CreateDrivers.selectAndroidDriver(Drivers.NATIVE);

    }


    @AfterClass
    public void tearDown(){

            driver.quit();
            serviceBuilder.stop();

    }
}
