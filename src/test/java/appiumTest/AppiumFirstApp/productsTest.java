package appiumTest.AppiumFirstApp;

import org.testng.annotations.Test;

public class productsTest extends BaseClass{
	
	@Test(priority = 1)
	public void Test2() {
		
		productsPOM.addProductToCart("Air Jordan 9 Retro");
		productsPOM.addProductToCart("PG 3");
		productsPOM.goToCart();
		
	}
	
}
