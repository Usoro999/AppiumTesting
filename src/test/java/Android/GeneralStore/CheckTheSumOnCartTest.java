package Android.GeneralStore;

import Android.AndroidActions.AndroidActions;
import Android.Configurations.AndroidBaseTest;
import Android.PageObjectsAndroid.CartPage;
import Android.PageObjectsAndroid.FormPage;
import Android.PageObjectsAndroid.ProductCatalog;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CheckTheSumOnCartTest extends AndroidBaseTest {
    AndroidActions androidActions;
    FormPage formPage;
    ProductCatalog productCatalog;
    CartPage cartPage;

    @Test
    public void checkTheSumOnCartTest() throws InterruptedException {
        androidActions = new AndroidActions(driver);
        cartPage = new CartPage(driver);
        formPage = new FormPage(driver);
        productCatalog = new ProductCatalog(driver);


        formPage.authorization("Soro","Argentina");

        productCatalog.selectTwoItems();
        productCatalog.navigateToCart();
        // Compare sum prices and totalAmount
        Assert.assertEquals(cartPage.getSumOfOrderItems(), cartPage.getTotalScreenAmount(), "The sums should be the same");

        cartPage.longPressOnTerms();

        Assert.assertEquals(cartPage.getTermsText(), "Terms Of Conditions");
        cartPage.closeTermMessage();
        cartPage.finishOrder();
        Thread.sleep(16000);

    }

}




