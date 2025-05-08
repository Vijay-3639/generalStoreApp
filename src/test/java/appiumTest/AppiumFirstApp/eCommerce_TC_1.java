package appiumTest.AppiumFirstApp;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import BaseTest.BaseClass;
import io.appium.java_client.AppiumBy;

public class eCommerce_TC_1 extends BaseClass{
	
	@Test	
	public void fillForm() throws InterruptedException {
		
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Rashmika");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElement(AppiumBy.androidUIAutomator(" new UiScrollable(new UiSelector()).scrollIntoView(text(\"Hong Kong\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Hong Kong\"]")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(4000);
		
	}
	
	@Test
	public void toastMessageCheck() throws InterruptedException {
		
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Male']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElement(AppiumBy.androidUIAutomator(" new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Australia\"]")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		//getting toast message
		String toastMsg = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		System.out.println(toastMsg);
		
		Assert.assertEquals(toastMsg.toLowerCase().trim(), "please enter your name");
		Thread.sleep(3000);
		
	}
	
	@Test
	public void addToCart() throws InterruptedException {
		
		//fill details
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Rashmika");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElement(AppiumBy.androidUIAutomator(" new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Australia\"]")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		//select the product and add to cart
		
		//android.widget.TextView[@text='Jordan Lift Off']//parent::div//android.widget.LinearLayout//android.widget.TextView[@text='ADD TO CART']
		driver.findElement(AppiumBy.androidUIAutomator(" new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan Lift Off\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Jordan Lift Off']//parent::android.widget.LinearLayout//android.widget.TextView[@text='ADD TO CART']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(2000);
		WebElement cartItem = driver.findElement(By.xpath("//android.widget.TextView[@text='Jordan Lift Off']"));
		Assert.assertTrue(cartItem.isDisplayed());		
	}
	
}
