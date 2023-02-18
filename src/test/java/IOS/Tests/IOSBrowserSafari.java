package IOS.Tests;

import IOS.Configurations.IOSBaseTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class IOSBrowserSafari extends IOSBaseTest {

    @Test
    public void safariTest(){

        //How to open a native app on the ios
        // Android 'appPackage' == Ios 'Bundle ID'.
        // Navigate to Apple to find Bundle id from 'Photos'

//        Open another app
        Map<String, String> params = new HashMap<>();
        params.put("bundleId", "com.apple.mobilesafari");
        driver.executeScript("mobile:launchApp", params);
        driver.get("https://support.apple.com/ru-ru/guide/deployment/depece748c41/web");




    }
}
