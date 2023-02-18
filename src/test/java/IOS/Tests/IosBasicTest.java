package IOS.Tests;

import IOS.Configurations.IOSBaseTest;
import IOS.PageObjects.AlertViewsPage;
import IOS.PageObjects.HomePage;

import IOS.Configurations.ListenersIOS;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(ListenersIOS.class)
public class IosBasicTest extends IOSBaseTest {
    HomePage homePage;
    AlertViewsPage alertViewsPage;
    @Test
    public void simpleTest(){
        homePage = new HomePage(driver);
        alertViewsPage = new AlertViewsPage(driver);


        homePage.clickAlertViewsBtn();
        alertViewsPage.clickTextEntry();
        alertViewsPage.sendTextToTextEntry("Automation");
        alertViewsPage.clickTextEntryOK();
// Check the message should be the same
        alertViewsPage.clickConfirmCancelBtn();

        Assert.assertEquals(alertViewsPage.getMessageText(), "A message should be a short, complete sentence.");

        alertViewsPage.clickConfirmBtn();



    }

}
