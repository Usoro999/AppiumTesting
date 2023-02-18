package Android.PageObjectsAndroid;

import Android.AndroidActions.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductCatalog extends AndroidActions {
    AndroidDriver driver;

    public ProductCatalog(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    
    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'ADD TO CART']")
    List<WebElement> addToCartBtn;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
    WebElement cartBtn;
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

    
    
    
    
    public void selectTwoItems() {
        // We ensure how many elements will be shown (3 or 2)
        int amountOfItems = addToCartBtn.size();
        if(amountOfItems == 3) {
            addToCartBtn.get(0).click();
            addToCartBtn.get(1).click();
        }else {
            addToCartBtn.get(0).click(); // After that it will be only one element on the page
            driver.findElement(By.xpath("//android.widget.TextView[@text = 'ADD TO CART']")).click();
        }
        
    }

    public void navigateToCart() {
        cartBtn.click();
        //Switching the pages are contained several seconds = necessarily to use Wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      //  wait.until(ExpectedConditions.attributeContains(cartTitle, "text", "Cart"));
        wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.refreshed(ExpectedConditions.attributeContains(cartTitle, "text", "Cart")));
    }

    public void addToCartOneItem(String item) {
        scrollToText(item);
        // Select the right element from list and click AddToCart

        for (int i = 0; i < productsNameList.size(); i++){
            if(productsNameList.get(i).getText().equals(item)){
                addToCartBtn.get(i).click();
            }

        }
    }
}
