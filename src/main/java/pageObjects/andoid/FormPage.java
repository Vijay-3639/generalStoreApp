package pageObjects.andoid;

import org.checkerframework.checker.index.qual.LessThan;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class FormPage extends BasePage {

	public FormPage(AndroidDriver driver) {
		super(driver);
	}

	@AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
	private WebElement nameField;

	public void name(String name) {
		nameField.sendKeys(name);
	}

	@AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Male']")
	private WebElement genderMale;

	@AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Female']")
	private WebElement genderFemale;
	
	public void gender(String gender) {
		if(gender.equalsIgnoreCase("male")) {
			genderMale.click();
		}
		else {
			genderFemale.click();
		}
	}

	@AndroidFindBy(id = "com.androidsample.generalstore:id/spinnerCountry")
	private WebElement countryField;

	public void selectCountry(String countryName) {
		countryField.click();
		scrollToView(countryName);
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='" + countryName + "']")).click();
	}

	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
	private WebElement letsShop;
	
	public void letsShopClick() {
		letsShop.click();		
	}

}