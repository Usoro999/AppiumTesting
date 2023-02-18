package IOS.Configurations;

import IOS.Configurations.IOSBaseTest;

import Utils.TakeScreenShots;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;


public class ListenersIOS extends IOSBaseTest implements ITestListener {

    @Override
    public void onTestSuccess(ITestResult result) {
        Allure.addAttachment(result.getMethod().getMethodName()+"Screen",
                new ByteArrayInputStream(driver.getScreenshotAs(OutputType.BYTES)));

    }

    @Override
    public void onTestFailure(ITestResult result) {
        Allure.addAttachment(result.getMethod().getMethodName()+"Screen",
                new ByteArrayInputStream(driver.getScreenshotAs(OutputType.BYTES)));
    }


}
