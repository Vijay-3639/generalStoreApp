package pageObjects.andoid;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;

public class cartPage extends BasePage {

	public cartPage(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@AndroidBy(id = "com.androidsample.generalstore:id/productPrice")
	private List<WebElement> productPrices;

	public double totalProductsPrice() {
		double totalPrice = 0;
		for (int i = 0; i < productPrices.size(); i++) {
			totalPrice += Double.parseDouble(productPrices.get(i).getText().substring(1));
		}
		return totalPrice;
	}

	@AndroidBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
	private WebElement cartPriceElement;

	public double cartPrice() {
		double cartPrice = Double.parseDouble(cartPriceElement.getText().substring(1));
		return cartPrice;
	}

	@AndroidBy(id = "com.androidsample.generalstore:id/termsButton")
	private WebElement termsElement;

	public void termsLongClick() {
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) termsElement).getId(), "duration", 2000));
	}
	
	@AndroidBy(id = "android:id/button1")
	private WebElement close;
	
	@AndroidBy(className = "android.widget.CheckBox")
	private WebElement checkbox;
	
	@AndroidBy(id = "com.androidsample.generalstore:id/btnProceed")
	private WebElement proceed;
	
	public void proceed() {
		close.click();
		checkbox.click();
		proceed.click();
	}
}
