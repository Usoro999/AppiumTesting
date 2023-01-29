package Android.GeneralStore;

import Configurations.BaseTest;
import Android.PageObjectsAndroid.CartPage;
import Android.PageObjectsAndroid.FormPage;
import Android.PageObjectsAndroid.ProductCatalog;
import org.testng.Assert;
import org.testng.annotations.Test;


public class OrderOneItem extends BaseTest {
    FormPage formPage = new FormPage(driver);
    CartPage cartPage = new CartPage(driver);
    ProductCatalog productCatalog = new ProductCatalog(driver);
    @Test
    public void orderOneItem() throws InterruptedException {

        formPage.authorization();

        productCatalog.addToCartOneItem("Jordan 6 Rings");
        productCatalog.navigateToCart();

        // Check selected item in the Shopping cart
        Assert.assertEquals(cartPage.checkAddedItemName(),"Jordan 6 Rings");
        cartPage.finishOrder();








        }


    }

