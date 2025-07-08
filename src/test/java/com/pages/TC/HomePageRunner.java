package com.pages.TC;

import org.testng.annotations.Test;

public class HomePageRunner extends TestBase {
	@Test
	public void verifyLogoButtonFunctional() {
		HomePage homepage = new HomePage();
		// homepage.clickOnBrowserPopup();
		homepage.clickOnLogoButton();
		homepage.assertThatLogoButtonIsFunctional();
	}

	@Test
	public void verifyUpdateLocationButton() {
		HomePage homepage = new HomePage();
		// homepage.clickOnBrowserPopup();
		homepage.clickOnUpdateLocationButton();
		homepage.assertThatUpdateLocationButtonIsFunctional();
	}

	@Test
	public void allDropdownButtonClickableAndFunctional() {
		HomePage homepage = new HomePage();
		// homepage.clickOnBrowserPopup();
		homepage.clickOnallDropdownHeader();
		homepage.selectOptionFromAllDropdown();
		homepage.assertOptionFromAllDropdownIsSelected();
	}

	@Test
	public void allDropdownl2ndOrFurtherOptionSelectsearchBoxActive() {
		HomePage homepage = new HomePage();
		homepage.clickOnallDropdownHeader();
		homepage.select2ndOptionFromAllDropdown();
		homepage.assertThatSearchBoxActiveAfter2ndOrMoreOptionSelected();
	}

	@Test
	public void allDropdown1stOptionSelectSearchBoxNotActive() {
		HomePage homepage = new HomePage();
		homepage.clickOnallDropdownHeader();
		homepage.select1stOptionFromAllDropdown();
		homepage.assertThatSearchBoxActiveAfter1stOptionSelected();
	}

	@Test
	public void SearchboxInvalidProductInputFallbackOrDefaultResultsNoErrorMessage() {
		HomePage homepage = new HomePage();
		homepage.enterValidOrInvalidProductNameInSearchBox("sdfsdjknxjfczmx c.,;ls,zklmkedmawkmdckmz");
		homepage.clickOnSubmitButton();
		homepage.assertThatFallBackResultsAreDisplayed();
	}

	@Test
	public void SearchboxIncompleteProductInputMatchingResults() throws InterruptedException {
		HomePage homepage = new HomePage();
		homepage.enterValidOrInvalidProductNameInSearchBox("fuel");
		homepage.verifyMatchingResultsAreDisplayed();
	}

}
