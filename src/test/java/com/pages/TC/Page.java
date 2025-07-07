package com.pages.TC;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Page {
	protected static RemoteWebDriver driver;

	public static void invokeBrowser() {
		EdgeOptions options = new EdgeOptions();
		Map<String, Object> prefs = new HashMap<>();

		// Disable notifications
		prefs.put("profile.default_content_setting_values.notifications", 2);

		options.setExperimentalOption("prefs", prefs);

		driver = new EdgeDriver(options);

	}

	public static void maximizeBrowser() {
		driver.manage().window().maximize();

	}

	public static void browserPopUpHandle() {

	}

	public static void launchURL(String url) {
		driver.get(url);
	}

	public static Boolean assert_True(boolean condition) {
		Assert.assertTrue(condition);
		return true;
	}

	public static void selectDropDown(WebElement element, String type, String value) {
		Select select = new Select(element);
		switch (type) {
		case "index":
			select.selectByIndex(Integer.parseInt(value));
			break;
		case "value":
			select.selectByValue((value));
			break;
		case "visibletext":
			select.selectByVisibleText((value));
			break;
		case "containsvisibletext":
			select.selectByContainsVisibleText(value);
			break;
		default:
			throw new IllegalArgumentException(value);
		}
	}

	public static void closeWindow() {
		driver.close();
	}

	public static void quitAllWindows() {
		driver.quit();
	}

	public static void implicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));

	}
}
