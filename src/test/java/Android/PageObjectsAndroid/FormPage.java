package PageObjectsAndroid;

import Android.AndroidActions.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class FormPage extends AndroidActions {

    AndroidDriver driver;

    public FormPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.androidsample.generalstore:id/spinnerCountry")
    private WebElement countryMenu;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Argentina']")
    private WebElement countryName;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
    private WebElement nameField;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
    private WebElement buttonLetsShop;

    @AndroidFindBy(xpath = "//android.widget.Toast)[1]")
    private WebElement toastMessage;

    public void selectCountry(String country) {

        countryMenu.click();
        scrollToText(country);
        driver.findElement(By.xpath("//android.widget.TextView[@text = '" + country + "']")).click();

    }

    public void fillNameField(String name) {
        nameField.sendKeys(name);
        hideKeyboard();

    }

    public void clickBtnLetsShop() {
        buttonLetsShop.click();
    }

    public String getToastMessageText() {
        //Catch error toast text
        // using xpath and "//android.widget.Toast" and not-shown attribute "name"
        return toastMessage.getAttribute("name");
    }

    public void authorization() throws InterruptedException {
        selectCountry("Argentina");
        fillNameField("Soro");
        clickBtnLetsShop();

    }
}
