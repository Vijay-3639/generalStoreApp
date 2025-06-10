package appiumTest.AppiumFirstApp;

import org.testng.Assert;
import org.testng.annotations.Test;

public class cartTest extends BaseClass{
		
	@Test			
	public void cartPriceValidation() {
		
		double totalProductsPrice = cartPOM.totalProductsPrice();
		double cartPrice = cartPOM.cartPrice();
		Assert.assertEquals(totalProductsPrice, cartPrice);

	}
	
	@Test
	public void test3() {
		cartPOM.termsLongClick();
		cartPOM.proceed();
		
//		Set<String> contextHandles = driver.getContextHandles();
//		for(String context: contextHandles) {
//			System.out.println(context);
//		}
//		
//		driver.context("WEBVIEW_com.androidsample.generalstore");
//		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//		WebElement google = driver.findElement(By.name("q"));
//		wait.until(ExpectedConditions.visibilityOf(google));
//		google.sendKeys("Yayyyy!!!");
//		Thread.sleep(5000);
//		driver.context("NATIVE_APP");
	}
	
}
