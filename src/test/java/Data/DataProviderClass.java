package Data;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

    @DataProvider(name="getDataForm")
    public static Object[][] getDataForm(){
        return new Object[][]
                {
                        {"Martin", "Argentina", "Avellaneda", "1234567894545", "08", "2025"}
                };
    }
}


