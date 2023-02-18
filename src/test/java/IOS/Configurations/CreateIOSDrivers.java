package IOS.Configurations;

import io.appium.java_client.ios.IOSDriver;

import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class CreateIOSDrivers extends IOSBaseTest {

    public static IOSDriver selectIOSDriver(Drivers driver) throws IOException {
        switch (driver) {

            case IOSDRIVER: createIOSDriver();
        }
        return IOSBaseTest.driver;
    }


    private static void createIOSDriver() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/test/resources/data.properties"));

        serviceBuilder = startAppiumServer(properties.getProperty("ipAddress"), Integer.parseInt(properties.getProperty("port")));

            XCUITestOptions xcuiTestOptions = new XCUITestOptions();
            xcuiTestOptions.setDeviceName("Iphone 12 pro");
            xcuiTestOptions.setCapability(MobileCapabilityType.UDID,"216CBD5A-9D4B-4C42-AD09-C95C655CFFC5");
            xcuiTestOptions.setApp("/Users/yurii/MyFiles/JavaProjects/AppiumTesting/src/test/resources/UIKitCatalog.app");
            xcuiTestOptions.setPlatformVersion("16.2");
        // We need to wait for WebDriverAgent install on iPhone
            xcuiTestOptions.setWdaLaunchTimeout(Duration.ofSeconds(20));

            driver = new IOSDriver(serviceBuilder, xcuiTestOptions);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    private static void createRealIosDevice() throws IOException {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("src/test/resources/data.properties");
        properties.load(fileInputStream);
        serviceBuilder = startAppiumServer(properties.getProperty("ipAddress"), Integer.parseInt(properties.getProperty("port")));


        XCUITestOptions xcuiTestOptions = new XCUITestOptions();
        xcuiTestOptions.setDeviceName("Iphone");
        xcuiTestOptions.setApp("/Users/yurii/MyFiles/JavaProjects/AppiumTesting/src/test/resources/UIKitCatalog.app");
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
