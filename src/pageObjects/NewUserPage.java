package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import testFramework.SeleniumBase;

public class NewUserPage extends BasePage {
	
	private final By userNameFieldSelector = By.cssSelector("input#inputUserName");
	private final By userEmailFieldSelector = By.cssSelector("input#inputUserEmail");
	private final By submitBtnSelector = By.cssSelector("button#btnSubmit");
	
	protected boolean verifyCorrectUrl() {
		return super.getUrl().contains("/newuser");
	}
	
	public boolean enterUserName(String userName) {
		WebElement userNameField = SeleniumBase.driver.findElement(userNameFieldSelector);
		userNameField.sendKeys(userName);
		return userNameField.getAttribute("value").equals(userName);
	}
	
	public boolean enterEmailField(String email) {
		WebElement userEmailField = SeleniumBase.driver.findElement(userEmailFieldSelector);
		userEmailField.sendKeys(email);
		return userEmailField.getAttribute("value").equals(email);
	}
	
	public void pressSelectButton() {
		WebElement selectBtn = SeleniumBase.driver.findElement(submitBtnSelector);
		selectBtn.click();
		//TODO: Check page changes, may need wait.
	}


}
