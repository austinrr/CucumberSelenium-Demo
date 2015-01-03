package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import testFramework.SeleniumBase;

public class HomePage extends BasePage {
	
	private final By helloWorldLinkSelector = By.linkText("Hello World!.");
	private final By newUserPageLinkSelector = By.linkText("Add a new user.");
	private final By userUserListLinkSelector = By.linkText("User list.");
	
	public boolean goToHomePage() {
		return super.clickHomeLink();
	}

	public boolean verifyCorrectUrl() {
		return super.getUrl().contains("/homepage");
	}
	
	public void clickHelloWorldLink() {
		WebElement helloWorldPageLink = SeleniumBase.driver.findElement(helloWorldLinkSelector);
		helloWorldPageLink.click();
	}
	
	public void clickNewUserLink() {
		WebElement newUserPageLink = SeleniumBase.driver.findElement(newUserPageLinkSelector);
		newUserPageLink.click();
	}
	
	public void clickUserListLink() {
		WebElement userListLink = SeleniumBase.driver.findElement(userUserListLinkSelector);
		userListLink.click();
	}
}
