package Android.PageObjectsAndroid;

import Android.AndroidActions.AndroidActions;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormPage extends AndroidActions {

    protected AndroidDriver driver;

    public FormPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.androidsample.generalstore:id/spinnerCountry")
    WebElement countryMenu;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Argentina']")
    WebElement countryName;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
    WebElement nameField;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
    WebElement buttonLetsShop;

    @AndroidFindBy(xpath = "(//android.widget.Toast)[1]")
    WebElement toastMessage;

    private void selectCountry(String country) {

        countryMenu.click();
        scrollToText(country);
        driver.findElement(By.xpath("//android.widget.TextView[@text = \""+country+"\"]")).click();

    }

    private void fillNameField(String name) {
        nameField.sendKeys(name);
        hideKeyboard();

    }

    private void clickBtnLetsShop() {
        buttonLetsShop.click();
    }

    public String getToastMessageText() {
        //Catch error toast text
        // using xpath and "//android.widget.Toast" and not-shown attribute "name"
        return toastMessage.getAttribute("name");
    }

    public void authorization(String name, String country) throws InterruptedException {
        selectCountry(country);
        fillNameField(name);
        clickBtnLetsShop();
    }
    public void setActivity(){

        //adb shell dumpsys window | grep -E 'mCurrentFocus'
        Activity activity = new Activity("com.androidsample.generalstore","com.androidsample.generalstore.MainActivity");
        driver.startActivity(activity);
    }
}
