package test.java.framework;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriverUtils {
	
	public static final String USERNAME = "testingucu.2017";
	public static final String ACCESS_KEY = "822c92b4-028e-4448-9507-0f13c1a1d720";
	public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";
	
	public enum Browser {
		Firefox, Chrome
	}
	
	public static WebDriver create() {
		System.setProperty("webdriver.chrome.driver", "/Users/gabo/Desktop/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}

	public static WebDriver create(String platform, Browser browser, String version) throws MalformedURLException {
		DesiredCapabilities caps = null;
		
		switch(browser) {
		case Firefox:
			caps = DesiredCapabilities.firefox();
			break;
			
		case Chrome:
			caps = DesiredCapabilities.chrome();
			break;
		
		default: throw new IllegalArgumentException("Invalid browser selected.");
		}
		
		caps.setCapability("platform", platform);
		caps.setCapability("version", version);
		 
		WebDriver driver = new RemoteWebDriver(new java.net.URL(URL), caps);
		return driver;
	}
	
	public static void quit(WebDriver driver) {
		if(driver != null) {
			driver.quit();
		}
	}

}
