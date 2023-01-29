package Configurations;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;
import java.time.Duration;

public class CreateIOSDrivers extends IosBaseTest {

    public static IOSDriver selectIOSDriver(Drivers driver) {
        switch (driver) {

            case IOSDRIVER: createIOSDriver();
        }
        return IosBaseTest.driver;
    }


    private static void createIOSDriver() {
        if (serviceBuilder == null) {
            serviceBuilder = new AppiumServiceBuilder()
                    //  .withAppiumJS(new File("C:\\Users\\Shocoman\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                    .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                    .withIPAddress("127.0.0.1").usingPort(4723).build();
            serviceBuilder.start();
        }


            XCUITestOptions xcuiTestOptions = new XCUITestOptions();
            xcuiTestOptions.setDeviceName("Iphone 12 pro");
            xcuiTestOptions.setCapability(MobileCapabilityType.UDID,"216CBD5A-9D4B-4C42-AD09-C95C655CFFC5");
            xcuiTestOptions.setApp("/Users/yurii/MyFiles/JavaProjects/ATest/src/test/resources/UIKitCatalog.app");
            xcuiTestOptions.setPlatformVersion("16.2");
        // We need to wait for WebDriverAgent install on iPhone
            xcuiTestOptions.setWdaLaunchTimeout(Duration.ofSeconds(20));

            driver = new IOSDriver(serviceBuilder, xcuiTestOptions);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    private static void createRealIosDevice(){
        if (serviceBuilder == null) {
            serviceBuilder = new AppiumServiceBuilder()
                    //  .withAppiumJS(new File("C:\\Users\\Shocoman\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                    .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                    .withIPAddress("127.0.0.1").usingPort(4723).build();
            serviceBuilder.start();
        }


        XCUITestOptions xcuiTestOptions = new XCUITestOptions();
        xcuiTestOptions.setDeviceName("Iphone");
        xcuiTestOptions.setApp("/Users/yurii/MyFiles/JavaProjects/ATest/src/test/resources/UIKitCatalog.app");
        xcuiTestOptions.setPlatformVersion("16.2");
        //real devices capabilities
        xcuiTestOptions.setCapability("xcodeOrgId", "");  // ->>> Sign in to developer.apple.com/account, and click Membership in the sidebar
        xcuiTestOptions.setCapability("xcodeSigningId", "iPhone Developer");
        xcuiTestOptions.setCapability("udid", "");   // ->>> You can grab the udid in iTunes
        xcuiTestOptions.setCapability("updateWDABundleID", "");
        // We need to wait for WebDriverAgent install on iPhone
        xcuiTestOptions.setWdaLaunchTimeout(Duration.ofSeconds(20));

        driver = new IOSDriver(serviceBuilder, xcuiTestOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

}
