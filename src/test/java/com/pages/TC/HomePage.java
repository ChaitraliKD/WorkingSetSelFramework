package com.pages.TC;
import static com.pages.TC.Page.assert_True;
import static com.pages.TC.Page.driver;
import static com.pages.TC.Page.selectDropDown;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	private static final Logger LOG = LogManager.getLogger(HomePage.class);
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
	@FindBy(xpath = "//form[@class='nav-searchbar nav-progressive-attribute nav-active']")
	WebElement activeSearchBox;
	@FindBy(xpath = "//form[@class='nav-searchbar nav-progressive-attribute']")
	WebElement inactiveSearchBox;
	@FindBy(css = "input[placeholder='Search Amazon']")
	WebElement searchBox;
	@FindBy(css = "input#nav-search-submit-button")
	WebElement searchBoxSubmitButton;
	@FindBy(xpath = "// span[@class='a-size-base a-color-secondary a-text-normal']")
	WebElement fallbackOrDefaultResultConfirmationText;
	HomePage() {
		PageFactory.initElements(driver, this);
	}

	/*
	 * public void clickOnBrowserPopup() { browserPopUp.click(); }
	 */

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
		selectDropDown(allDropdownSelectTag, "index", "3");
	}

	public void assertOptionFromAllDropdownIsSelected() {
		LOG.info(allDropdownSelectedOptionText.getText());
		assert_True(allDropdownSelectedOptionText.getText().equals("Baby"));
	}

	public void select2ndOptionFromAllDropdown() {
		selectDropDown(allDropdownSelectTag, "index", "3");
	}

	public void assertThatSearchBoxActiveAfter2ndOrMoreOptionSelected() {
		assert_True(activeSearchBox.isEnabled());
	}

	public void select1stOptionFromAllDropdown() {
		selectDropDown(allDropdownSelectTag, "index", "0");
	}

	public void assertThatSearchBoxActiveAfter1stOptionSelected() {
		assert_True(inactiveSearchBox.isEnabled());
	}

	public void enterValidOrInvalidProductNameInSearchBox(String productName) {
		searchBox.sendKeys(productName);
	}

	public void clickOnSubmitButton() {
		searchBoxSubmitButton.click();
	}

	public void assertThatFallBackResultsAreDisplayed() {
		assert_True(fallbackOrDefaultResultConfirmationText.getText().toLowerCase()
				.equalsIgnoreCase("Check each product page for other buying options."));
	}

	public void verifyMatchingResultsAreDisplayed() throws InterruptedException {// stale element reference: stale
																					// element not found in the current
																					// frame
		List<WebElement> freshList = driver.findElements(By.cssSelector(
				"div.left-pane-results-container>div div[class='s-suggestion s-suggestion-ellipsis-direction']"));
		Thread.sleep(2000);
		System.out.println("freshList size: " + freshList.size());
		for (WebElement list : freshList) {


			System.out.println("expected: " + list.getText().toLowerCase());
		}
	}

}



	/*
	 * 
	 * 
	 * @Test(dataProvider = "ProductList", dataProviderClass = reusablecode.class)
	 * public static void
	 * BeforeLogin_Searchbox_validProductInput_validMatchingResults(String
	 * productname) { driver.findElement(searchBox).sendKeys(productname);
	 * driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click
	 * (); List<WebElement> titles = driver .findElements(By.
	 * xpath("//h2[@class='a-size-medium a-spacing-none a-color-base a-text-normal']/span"
	 * )); for (WebElement title : titles) {
	 * Assert.assertTrue(title.getText().toLowerCase().contains(productname));
	 * 
	 * } }
	 * 
	 * public void BeforeLogin_Searchbox_incompleteProductInput_MatchingResults()
	 * throws InterruptedException { String input="fuel";
	 * driver.findElement(searchBox).sendKeys(input); Thread.sleep(3000);
	 * List<WebElement> autoSuggestions = driver.findElements(By.xpath(
	 * "//div[@class='left-pane-results-container']/descendant::div[@class='s-suggestion s-suggestion-ellipsis-direction']"
	 * )); for (WebElement autoSuggestion : autoSuggestions) {
	 * Assert.assertTrue(autoSuggestion.getText().contains(input)); } }
	 */


