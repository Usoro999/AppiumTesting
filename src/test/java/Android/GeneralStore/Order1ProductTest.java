package Android.GeneralStore;

import Android.Configurations.AndroidBaseTest;
import Android.PageObjectsAndroid.CartPage;
import Android.PageObjectsAndroid.FormPage;
import Android.PageObjectsAndroid.ProductCatalog;
import io.appium.java_client.android.Activity;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Order1ProductTest extends AndroidBaseTest {
    FormPage formPage;
    CartPage cartPage;
    ProductCatalog productCatalog;
    @Test
    public void order1ProductTest() throws InterruptedException {


        formPage = new FormPage(driver);
        cartPage = new CartPage(driver);
        productCatalog  = new ProductCatalog(driver);


        formPage.authorization("Soro","Argentina");

        productCatalog.addToCartOneItem("Jordan 6 Rings");
        productCatalog.navigateToCart();

        // Check selected item in the Shopping cart
        Assert.assertEquals(cartPage.checkAddedItemName(),"Jordan 6 Rings");
        Activity activity = new Activity("com.androidsample.generalstore","com.androidsample.generalstore.MainActivity");
        driver.startActivity(activity);
       // cartPage.finishOrder();








        }


    }

