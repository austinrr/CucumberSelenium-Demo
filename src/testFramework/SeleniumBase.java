package testFramework;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class SeleniumBase {

	public static WebDriver driver = null;
	private String baseUrl;
	private String browserName;
	private String browserVersion;
	private Properties props;
	private Capabilities caps;
			
	public SeleniumBase() throws Exception {
		this.props = testFramework.readConfigFile.getProps();
		setProps();
	}
	
	private WebDriver getBrowser() {
		switch (browserVersion) {
			case "Chrome" :
				return new ChromeDriver();
		case "InternetExplorer" :
				return new  InternetExplorerDriver();
		case "Firefox" :
				return new FirefoxDriver();
		case "Safari" :
				return new SafariDriver();
		default :
				return new FirefoxDriver();	
		}
	}
	
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "../dependencies/chromedriver.exe");
		driver = getBrowser();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		caps = ((RemoteWebDriver) driver).getCapabilities();
		browserName = caps.getBrowserName();
		browserVersion = caps.getVersion();
		System.out.println("Automated test run. We’re running on "+browserName+" "+browserVersion);
	}
	
	private void setProps() {
//		I think reading the file is broken because the thread is not properly closed.
//		this.baseUrl = props.getProperty(baseUrl);
//		this.browserName = props.getProperty(browserName);
//		this.browserVersion = props.getProperty(browserVersion, null);
	
		this.baseUrl = "http://localhost:3000/homepage";
		this.browserName = "Firefox";
		this.browserVersion = "";
	}
	
	public void tearDown() {
		driver.quit();
	}
	
	public void goToHomePage(){
		driver.get(baseUrl);	
	 }
}
