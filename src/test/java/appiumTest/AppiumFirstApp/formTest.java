package appiumTest.AppiumFirstApp;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class formTest extends BaseClass {

	@Test(dataProvider = "getData", priority = 1)
	public void Test1(HashMap<String, String> input) {

		formPOM.name(input.get("name"));
		driver.hideKeyboard();
		formPOM.gender(input.get("gender"));
		formPOM.selectCountry(input.get("country"));
		formPOM.letsShopClick();
	}

	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = getJsonData(
				System.getProperty("user.dir") + "\\src\\test\\resources\\testData.json");

		return new Object[][] { 
			{ data.get(0) }, 
			{ data.get(1) } 
		};
	}

}
