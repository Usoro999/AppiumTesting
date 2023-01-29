package Appium.Gestures;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.time.Duration;


public class BaseTest {
    protected static AndroidDriver androidDriver;
    private AppiumDriverLocalService serviceBuilder;



    @BeforeTest
    public void ConfigureAppium(){

        if(serviceBuilder==null) {
            serviceBuilder = new AppiumServiceBuilder()
                  //  .withAppiumJS(new File("C:\\Users\\Shocoman\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                    .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                    .withIPAddress("127.0.0.1").usingPort(4723).build();
            serviceBuilder.start();

            // First option to set capabilities in Appium 2.0
            UiAutomator2Options options = new UiAutomator2Options();
            options.setDeviceName("Pixel 5 API 31");
            options.setApp("src\\test\\resources\\ApiDemos-debug.apk");

            // Second option to set capabilities in Appium 1.22 and 2.0
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel");
            capabilities.setCapability(MobileCapabilityType.UDID,"emulator-5554");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"12.0");
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
            capabilities.setCapability(MobileCapabilityType.APP,"src/test/resources/ApiDemos-debug.apk");

            androidDriver = new AndroidDriver(serviceBuilder, capabilities);
            androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
    }


    @AfterTest
    public void tearDown(){
        if(androidDriver!=null) {
            androidDriver.quit();
            serviceBuilder.stop();
        }
    }
}
