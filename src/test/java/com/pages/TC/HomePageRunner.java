package com.pages.TC;

import org.testng.annotations.Test;

public class HomePageRunner extends TestBase {
	@Test
	public void verifyLogoButtonFunctional() {
		HomePage homepage = new HomePage();
		homepage.clickOnBrowserPopup();
		homepage.clickOnLogoButton();
		homepage.assertThatLogoButtonIsFunctional();
	}

	@Test
	public void verifyUpdateLocationButton() {
		HomePage homepage = new HomePage();
		homepage.clickOnBrowserPopup();
		homepage.clickOnUpdateLocationButton();
		homepage.assertThatUpdateLocationButtonIsFunctional();
	}

	@Test
	public void allDropdownButtonClickableAndFunctional() {
		HomePage homepage = new HomePage();
		homepage.clickOnBrowserPopup();
		homepage.clickOnallDropdownHeader();
		homepage.selectOptionFromAllDropdown();
		homepage.assertOptionFromAllDropdownIsSelected();
	}
}
