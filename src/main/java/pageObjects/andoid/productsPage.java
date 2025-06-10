package pageObjects.andoid;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;

public class productsPage extends BasePage {

	public productsPage(AndroidDriver driver) {
		super(driver);
	}

	public void addProductToCart(String name) {

		scrollToView(name);
		driver.findElement(By.xpath("//android.widget.TextView[@text='" + name
				+ "']//parent::android.widget.LinearLayout//android.widget.TextView[@text='ADD TO CART']")).click();
	}

	@AndroidBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement cartElement;

	public void goToCart() {
		cartElement.click();
	}

}
