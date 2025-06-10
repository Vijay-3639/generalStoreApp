package appiumTest.AppiumFirstApp;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;
import com.google.errorprone.annotations.Immutable;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.opentelemetry.sdk.metrics.internal.view.DropAggregation;

public class BaseClass2 {

	public AppiumDriverLocalService appiumServiceBuilder;
	public AndroidDriver driver;

	@BeforeClass
	public void configureAppium() throws MalformedURLException, URISyntaxException {

		appiumServiceBuilder = new AppiumServiceBuilder().withAppiumJS(new File(
				"c:\\Users\\vijay.LAPTOP-CCJ7C4DN\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		appiumServiceBuilder.start();

		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Android Device");
		options.setApp(
				"\\Users\\vijay.LAPTOP-CCJ7C4DN\\eclipse-workspace\\AppiumFirstApp\\src\\test\\resources\\General-Store.apk");
		driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	// @AfterClass
	public void stopSession() {
		driver.quit();
		// appiumServiceBuilder.stop();
	}

	public void longPressAction(WebElement element) {
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "duration", 2000));
	}

}
