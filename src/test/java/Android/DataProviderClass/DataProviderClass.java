package Android.DataProviderClass;

import Android.Configurations.AndroidBaseTest;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class DataProviderClass extends AndroidBaseTest {
    @DataProvider
    public static Object[][] userData(){
        return new Object[][]{
                {"Soro Yurii", "Argentina"},
                {"Solovey A", "Angola"}
        };
    }
    @DataProvider
    public static Object[][] invalidUserData(){
        return new Object[][]{
                {"", "Argentina"},
                {"", "Angola"}
        };
    }
    @DataProvider
    public static Object[][] getDataFromJson() throws IOException {
        List<HashMap<String , String >> data = getJsonToMap("src/test/resources/dataProvider.json");
        return new Object[][]{
                {data.get(0)},
                {data.get(1)}
        };
    }
}
