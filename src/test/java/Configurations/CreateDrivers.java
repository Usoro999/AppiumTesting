package Configurations;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.time.Duration;

public class CreateDrivers extends BaseTest {

    public static AndroidDriver selectAndroidDriver(Drivers driver) {
        switch (driver) {
            case CHROME:
                createChromeDriver();
            case HYBRID:
                createHybridDriver();
            case NATIVE:
                createNativeDriver();
        }
        return BaseTest.driver;
    }



    public static void createHybridDriver() {
        // Set and start Appium server
        if (serviceBuilder == null) {
            serviceBuilder = new AppiumServiceBuilder()
                    //  .withAppiumJS(new File("C:\\Users\\Shocoman\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                    .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                    .withIPAddress("127.0.0.1").usingPort(4723).build();
            serviceBuilder.start();

            // Option to set capabilities in Appium 2.0
            UiAutomator2Options options = new UiAutomator2Options();
            options.setDeviceName("Pixel");
            options.setApp("src/test/resources/General-Store.apk");
            options.setChromedriverExecutable("/Users/yurii/ChromeDriverForAutomation/chromedriver");

            driver = new AndroidDriver(serviceBuilder, options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
    }

    public static void createNativeDriver() {
        // Set and start Appium server
        if (serviceBuilder == null) {
            serviceBuilder = new AppiumServiceBuilder()
                    //  .withAppiumJS(new File("C:\\Users\\Shocoman\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                    .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                    .withIPAddress("127.0.0.1").usingPort(4723).build();
            serviceBuilder.start();

            // Option to set capabilities in Appium 2.0
            UiAutomator2Options options = new UiAutomator2Options();

            options.setDeviceName("Pixel");
//            if we want open exist app on the android:
//            options.setCapability("appPackage","com.whatsapp");
//            options.setCapability("appActivity","com.whatsapp.Main");
//              OR
//            options.setAppActivity("com.whatsapp");
//            options.setAppPackage("com.whatsapp.Main");

//            if we want to open uor app on the Android
            options.setApp("src/test/resources/General-Store.apk");


            driver = new AndroidDriver(serviceBuilder, options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
    }

    public static void createChromeDriver() {
        // Set and start Appium server
        if (serviceBuilder == null) {
            serviceBuilder = new AppiumServiceBuilder()
                    //  .withAppiumJS(new File("C:\\Users\\Shocoman\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                    .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                    .withIPAddress("127.0.0.1").usingPort(4723).build();
            serviceBuilder.start();

            // Option to set capabilities in Appium 2.0
            UiAutomator2Options options = new UiAutomator2Options();

            options.setDeviceName("Pixel");
            options.setChromedriverExecutable("/Users/yurii/ChromeDriverForAutomation/chromedriver");
            options.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");

            driver = new AndroidDriver(serviceBuilder, options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
    }

}
