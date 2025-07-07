package com.pages.TC;
import static com.pages.TC.Page.assert_True;
import static com.pages.TC.Page.driver;
import static com.pages.TC.Page.selectDropDown;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	@FindBy(css = "button[class='a-button-text']")
	WebElement browserPopUp;
	@FindBy(css = "a[id='nav-logo-sprites']")
	WebElement logoButton;
	@FindBy(css = "span#glow-ingress-line1")
	WebElement updateLocationButton;
	@FindBy(css = "h4#a-popover-header-1")
	WebElement chooseYourLocationDialogBoxText;
	@FindBy(css = "div[id='nav-search-dropdown-card']")
	WebElement allDropdownHeader;
	@FindBy(css = "select[aria-describedby='searchDropdownDescription']")
	WebElement allDropdownSelectTag;
	@FindBy(css = "span#nav-search-label-id")
	WebElement allDropdownSelectedOptionText;

	HomePage() {
		PageFactory.initElements(driver, this);
	}

	public void clickOnBrowserPopup() {
		browserPopUp.click();
	}

	public void clickOnLogoButton() {
		logoButton.click();
	}

	public void assertThatLogoButtonIsFunctional() {
		assert_True(driver.getCurrentUrl().toLowerCase().contains("logo"));
	}

	public void clickOnUpdateLocationButton() {
		updateLocationButton.click();
	}

	public void assertThatUpdateLocationButtonIsFunctional() {
		assert_True(chooseYourLocationDialogBoxText.getText().toLowerCase().contains("location"));
	}

	public void clickOnallDropdownHeader() {
		allDropdownHeader.click();
	}

	public void selectOptionFromAllDropdown() {
		selectDropDown(allDropdownSelectTag, "visibletext", "Baby");
	}

	public void assertOptionFromAllDropdownIsSelected() {
		System.out.println(allDropdownSelectedOptionText.getText());
		assert_True(allDropdownSelectedOptionText.getText().equals("Baby"));
	}

}
