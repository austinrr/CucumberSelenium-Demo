package pageObjects;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import testFramework.SeleniumBase;

public class UserListPage extends BasePage {
	
	private final By userTableSelector = By.cssSelector("table");
	private final By tableTrSelector = By.cssSelector("tr");
	private final By tableTdSelector = By.cssSelector("td");
	private final By tableThSelector = By.cssSelector("th");

	public boolean verifyCorrectUrl() {
		return super.getUrl().contains("/userlist");
	}
	
/*
 * This method is incredibly slow because of the number of findElement calls.
 * TODO: Reduce Selenium calls and focus on speeding by doing most of the manipulation after gathering table date. 
 */
	
	public List<Map<String, String>> getUserTable() {
		List<Map<String, String>> data = new ArrayList<Map<String, String>>();
		
		WebElement userTable = SeleniumBase.driver.findElement(userTableSelector);
		List<WebElement> trList = userTable.findElements(tableTrSelector);
		
		List<String> thCleanList = new ArrayList<String>();
		for (WebElement trElement : trList) {
			List<WebElement> tdList = trElement.findElements(tableTdSelector);
			List<WebElement> thList = trElement.findElements(tableThSelector);
			Map<String, String> row = new HashMap<String, String>();
			
			//First <tr> contains the header row <th> tags.
			for (WebElement thElement : thList) {
				thCleanList.add(thElement.getText());
			}
			
			//Every other <tr> is a row of user data.
			int tdPos = 0;
			for (WebElement tdElement : tdList) {
				String tdText = tdElement.getText();
				row.put(thCleanList.get(tdPos), tdText);
				tdPos ++;
			}
			if (!row.isEmpty()) data.add(row);
		}
		return data;
	}
}