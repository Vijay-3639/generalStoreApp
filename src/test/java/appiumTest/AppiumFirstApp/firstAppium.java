package appiumTest.AppiumFirstApp;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class firstAppium {
	
	@Test	
	void test() throws MalformedURLException, URISyntaxException {
		
		AppiumDriverLocalService appiumServiceBuilder = new AppiumServiceBuilder().withAppiumJS( new File("\\Users\\vijay.LAPTOP-CCJ7C4DN\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js")).withIPAddress("127.0.0.1").usingPort(4723).build();
		appiumServiceBuilder.start();
		
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Pixel 7a API 36");
		options.setApp("\\Users\\vijay.LAPTOP-CCJ7C4DN\\eclipse-workspace\\AppiumFirstApp\\src\\test\\resources\\General-Store.apk");
		AndroidDriver driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(),options);
		
		driver.quit();
		appiumServiceBuilder.stop();
	}
	
}
