package test.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import test.java.framework.SeleniumUtils;

public abstract class OpenCartBasePage {
	
	protected WebDriver driver;
	
	@FindBy(how = How.XPATH, using = "//input[@name='search']")
	private WebElement searchInput;
	
	@FindBy(how = How.XPATH, using = "//div[@id='search']//button")
	private WebElement searchButton;
	
	@FindBy(how = How.XPATH, using = "(//i[contains(@class,'shopping-cart')]//preceding::button[@data-toggle='dropdown'])[last()]")
	private WebElement openCartButton;
	
	@FindBy(how = How.XPATH, using = "//a[@title='My Account']")
	private WebElement myAccountButton;
	
	@FindBy(how = How.XPATH, using = "//div[@id='top-links']//a[text()='Login']")
	private WebElement loginButton;
	
	protected OpenCartBasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public SearchResult search(String string) {
		searchInput.sendKeys(string);
		searchButton.click();
		return new SearchResult(driver);
	}
	
	public void removeFromCart(String prod) throws InterruptedException {
		SeleniumUtils.waitForElementToBeVisible(driver, By.xpath("//button[contains(@class,'disabled')]"), 10);
		SeleniumUtils.waitForElementToDisappear(driver, By.xpath("//button[contains(@class,'disabled')]"), 30);
		openCartButton.click();
		WebElement removeButton = SeleniumUtils.getWebElement(driver, By.xpath("(//a[text()='"+ prod +"']//following::button[@title='Remove'])[1]"), 60);
		removeButton.click();
	}
	
	public LoginPage navigateToLogin() {
		myAccountButton.click();
		loginButton.click();
		return new LoginPage(driver);
	}
}
