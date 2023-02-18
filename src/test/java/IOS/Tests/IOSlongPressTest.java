package IOS.Tests;

import IOS.Configurations.IOSBaseTest;
import IOS.PageObjects.HomePage;
import IOS.PageObjects.SteppersPage;
import org.testng.annotations.Test;

public class IOSlongPressTest extends IOSBaseTest {
    HomePage homePage;
    SteppersPage steppersPage;
    @Test
    public void longPressTest(){
        homePage = new HomePage(driver);
        steppersPage = new SteppersPage(driver);

        homePage.clickSteppersBtn();
        steppersPage.longPressOnIncrementBtn();

    }
}
