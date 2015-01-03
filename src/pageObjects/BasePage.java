package pageObjects;

import org.openqa.selenium.By;
import testFramework.SeleniumBase;

abstract class BasePage {
	
	protected boolean clickHomeLink() {
		SeleniumBase.driver.findElement(By.cssSelector("div#header a")).click();
		return (SeleniumBase.driver.getCurrentUrl().contains("\\homepage"));
	}
	
	protected boolean goToURL(String url) {
		SeleniumBase.driver.get(url);
		return (SeleniumBase.driver.getCurrentUrl().contains(url));
	}
	
	protected String getUrl() {
		return SeleniumBase.driver.getCurrentUrl();
	}
	
	protected abstract boolean verifyCorrectUrl();
}
