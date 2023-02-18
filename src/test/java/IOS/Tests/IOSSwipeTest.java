package IOS.Tests;

import IOS.Configurations.IOSBaseTest;
import IOS.Gestures.IosActions;
import IOS.PageObjects.PhotosAppPage;
import org.testng.annotations.Test;

public class IOSSwipeTest extends IOSBaseTest {
    IosActions iosActions;
    PhotosAppPage photosAppPage;
    @Test
    public void swipeTest(){
        iosActions = new IosActions(driver);
        photosAppPage = new PhotosAppPage(driver);
        //How to open a native app on the ios
        // Android 'appPackage' == Ios 'Bundle ID'.
        // Navigate to Apple to find Bundle id from 'Photos'

//        Open another app
        iosActions.openAnotherApp("com.apple.mobileslideshow");
        photosAppPage.swipeAllPhotos();









    }
}
