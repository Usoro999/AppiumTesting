package Android.GeneralStore;

import Android.AndroidActions.AndroidActions;
import Configurations.BaseTest;
import Android.PageObjectsAndroid.CartPage;
import Android.PageObjectsAndroid.FormPage;
import Android.PageObjectsAndroid.GeneralCommands;
import Android.PageObjectsAndroid.ProductCatalog;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CheckTheSumOnCart extends BaseTest {
    AndroidActions androidActions = new AndroidActions(driver);
    GeneralCommands generalCommands = new GeneralCommands();
    FormPage formPage = new FormPage(driver);
    ProductCatalog productCatalog = new ProductCatalog(driver);
    CartPage cartPage = new CartPage(driver);

    @Test
    public void checkTheSum() throws InterruptedException {

        formPage.authorization();

        productCatalog.selectTwoItems();
        productCatalog.navigateToCart();
        // Compare sum prices and totalAmount
        Assert.assertEquals(cartPage.getSumOfOrderItems(), cartPage.getTotalScreenAmount(), "The sums should be the same");

        cartPage.longPressOnTerms();

        Assert.assertEquals(cartPage.getTermsText(), "Terms Of Conditions");

        cartPage.finishOrder();
        Thread.sleep(16000);

    }

}




