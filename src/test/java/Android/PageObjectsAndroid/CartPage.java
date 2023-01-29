package Android.PageObjectsAndroid;

import Android.AndroidActions.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends AndroidActions {
    AndroidDriver driver;

    public CartPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }


    @AndroidFindBy(id = "com.androidsample.generalstore:id/toolbar_title")
    WebElement cartTitle;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
    List<WebElement> itemPrices;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
    WebElement totalAmount;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/termsButton")
    WebElement terms;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/alertTitle")
    WebElement termsText;
    @AndroidFindBy(id = "android:id/button1")
    WebElement button1;
    @AndroidFindBy(xpath="//android.widget.CheckBox")
    WebElement checkbox;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnProceed")
    WebElement proceedBtn;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/productName")
    List<WebElement> productsNameList;





    public Double getSumOfOrderItems() {

        double sum = 0.0;
        for (int i = 0; i < itemPrices.size(); i++){
            double price = Double.parseDouble(itemPrices.get(i).getText().replace("$",""));
            sum = price + sum;
        }
        return sum;
    }

    public Double getTotalScreenAmount() {
        return Double.parseDouble(totalAmount.getText().replace("$ ",""));
    }

    public void longPressOnTerms() {
        longPressAction(terms);
    }

    public String getTermsText() {
        return termsText.getText();
    }

    public void finishOrder() {
        button1.click();
        checkbox.click();
        proceedBtn.click();
    }


    public String checkAddedItemName() {
        return productsNameList.get(0).getText();
    }
}
