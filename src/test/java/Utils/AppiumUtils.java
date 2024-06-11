package Utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

public abstract class AppiumUtils {
    protected static AppiumDriverLocalService serviceBuilder;

    public static AppiumDriverLocalService startAppiumServer(String ipAddress, int port){
        serviceBuilder = new AppiumServiceBuilder()
                //  .withAppiumJS(new File("C:\\Users\\Shocoman\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                .withIPAddress(ipAddress).usingPort(port).build();
        serviceBuilder.start();
        return serviceBuilder;
    }


    public void waitForElement(WebElement element, AppiumDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
        
    }

    public Double getTotalAmount(WebElement element) {
        return Double.parseDouble(element.getText().replace("$ ",""));
    }


    public static List<HashMap<String,String>> getJsonToMap(String jsonPath) throws IOException {
        String jsonContent = FileUtils.readFileToString(new File(jsonPath), StandardCharsets.UTF_8);
        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String,String>> data = mapper.readValue(jsonContent,
                new TypeReference<List<HashMap<String, String>>>() {
                });
        return data;
    }

    public String getScreenshot(String testCaseName, AppiumDriver driver) throws IOException {

        File source = driver.getScreenshotAs(OutputType.FILE);
        String screenFile = System.getProperty("src/test/reports/" +testCaseName+".png");
        FileUtils.copyFile(source, new File(screenFile));
        return screenFile;

    }
}
