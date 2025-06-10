package appiumTest.AppiumFirstApp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.BeforeTest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.cfg.MapperBuilder;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import pageObjects.andoid.FormPage;
import pageObjects.andoid.cartPage;
import pageObjects.andoid.productsPage;

public class BaseClass {

	public static AppiumDriverLocalService appiumServiceBuilder;
	public static AndroidDriver driver;

	public static FormPage formPOM;
	public static cartPage cartPOM;
	public static productsPage productsPOM;

	@BeforeTest
	public void configureAppium() throws MalformedURLException, URISyntaxException {

		appiumServiceBuilder = new AppiumServiceBuilder().withAppiumJS(new File(
				"\\Users\\vijay.LAPTOP-CCJ7C4DN\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		appiumServiceBuilder.start();

		Properties prop = new Properties();
		FileInputStream File = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\prop.properties");
		prop.load(File);
		String deviceName = prop.getProperty("deviceName");

		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName(deviceName);
		options.setApp(
				"\\Users\\vijay.LAPTOP-CCJ7C4DN\\eclipse-workspace\\AppiumFirstApp\\src\\test\\resources\\General-Store.apk");
		driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		formPOM = new FormPage(driver);
		productsPOM = new productsPage(driver);
		cartPOM = new cartPage(driver);

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

	public List<HashMap<String, String>> getJsonData(String filepath) throws IOException {
		String jsonContent = FileUtils.readFileToString(new File(filepath), StandardCharsets.UTF_8);
		ObjectMapper mapper = new ObjectMapper();

		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});

		return data;
	}

	static int i = 1;

	public static String screenShot() throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "\\ScreenShots\\" + i + "ss.png";
		File trgFile = new File(path);
		i++;
		FileUtils.copyFile(src, trgFile);
		return path;
	}

}
