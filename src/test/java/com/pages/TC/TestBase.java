package com.pages.TC;

import static com.pages.TC.Page.closeWindow;
import static com.pages.TC.Page.implicitWait;
import static com.pages.TC.Page.invokeBrowser;
import static com.pages.TC.Page.launchURL;
import static com.pages.TC.Page.maximizeBrowser;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
public class TestBase {

	@BeforeMethod
	public void openBrowser() throws InterruptedException {

		invokeBrowser();
		launchURL("https://www.amazon.com/");
		implicitWait();
		maximizeBrowser();
		Thread.sleep(4);
	}

	@AfterMethod
	public void quitBrowser() {
		closeWindow();
	}

}
