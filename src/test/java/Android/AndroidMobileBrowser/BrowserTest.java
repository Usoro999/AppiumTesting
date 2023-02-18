package Android.AndroidMobileBrowser;

import Android.Configurations.AndroidBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class BrowserTest extends AndroidBaseTest {

    @Test
    public void browserTesting() throws InterruptedException {
        driver.get("https://dou.ua/");
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)", "");
        Thread.sleep(5000);

        driver.findElement(By.xpath("//a[contains(text(),'Технічні статті')]")).click();
        Thread.sleep(5000);

    }
}
