package appiumTest.AppiumFirstApp;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import BaseTest.BaseClass;
import io.appium.java_client.AppiumBy;

public class eCommerce_TC_1 extends BaseClass{
	
	@Test	
	public void test() throws InterruptedException {
		
		
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Rashmika");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElement(AppiumBy.androidUIAutomator(" new UiScrollable(new UiSelector()).scrollIntoView(text(\"Hong Kong\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Hong Kong\"]")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(4000);
		
	}
	
}
