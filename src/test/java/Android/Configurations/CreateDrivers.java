package Android.Configurations;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumServiceBuilder;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class CreateDrivers extends AndroidBaseTest {

    public static AndroidDriver selectAndroidDriver(Drivers driver) throws IOException {
        switch (driver) {
            case CHROME:
                createChromeDriver();
            case HYBRID:
                createHybridDriver();
            case NATIVE:
                createNativeDriver();
        }
        return AndroidBaseTest.driver;
    }



    public static void createHybridDriver() throws IOException {
        // Set and start Appium server

        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("src/test/resources/data.properties");
        properties.load(fileInputStream);
        serviceBuilder = startAppiumServer(properties.getProperty("ipAddress"), Integer.parseInt(properties.getProperty("port")));

            // Option to set capabilities in Appium 2.0
            UiAutomator2Options options = new UiAutomator2Options();
            options.setDeviceName("Pixel");

            options.setApp("src/test/resources/General-Store.apk");
            options.setChromedriverExecutable("/Users/yurii/ChromeDriverForAutomation/chromedriver");
            options.setCapability("appWaitPackage","com.androidsample.generalstore");
            driver = new AndroidDriver(serviceBuilder.getUrl(), options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }


    public static void createNativeDriver() throws IOException {
        // Set and start Appium server
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("src/test/resources/data.properties");
        properties.load(fileInputStream);
        serviceBuilder = startAppiumServer(properties.getProperty("ipAddress"), Integer.parseInt(properties.getProperty("port")));

            // Option to set capabilities in Appium 2.0
            UiAutomator2Options options = new UiAutomator2Options();

            options.setDeviceName("Pixel");
//            if we want open exist app on the android:
//            options.setCapability("appPackage","com.whatsapp");
//            options.setCapability("appActivity","com.whatsapp.Main");
//              OR
//            options.setAppActivity("com.whatsapp");
//            options.setAppPackage("com.whatsapp.Main");

//            if we want to open our app on the Android
           options.setApp("src/test/resources/General-Store.apk");
         //   options.setApp("src/test/resources/ApiDemos-debug.apk");

            driver = new AndroidDriver(serviceBuilder.getUrl(), options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }


    public static void createChromeDriver() throws IOException {
        // Set and start Appium server
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("src/test/resources/data.properties");
        properties.load(fileInputStream);
        serviceBuilder = startAppiumServer(properties.getProperty("ipAddress"), Integer.parseInt(properties.getProperty("port")));

            // Option to set capabilities in Appium 2.0
            UiAutomator2Options options = new UiAutomator2Options();

            options.setDeviceName(properties.getProperty("AndroidDeviceName"));
            options.setChromedriverExecutable("/Users/yurii/ChromeDriverForAutomation/chromedriver");
            options.setCapability(MobileCapabilityType.BROWSER_NAME, properties.getProperty("browser"));

            driver = new AndroidDriver(serviceBuilder.getUrl(), options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }


}
