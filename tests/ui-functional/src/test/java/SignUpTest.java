package test.java;

import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;

import test.java.framework.WebDriverUtils;
import test.java.framework.WebDriverUtils.Browser;

@RunWith(Parameterized.class)
public class SignUpTest {

	public WebDriver driver;
	
	@Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                 { "Windows 10", Browser.Firefox, "53.0" }, 
                 { "Windows 10", Browser.Chrome, "58.0" },
           });
    }
	
    @Parameter(0)
	public String platform;

    @Parameter(1)
	public Browser browser;
    
    @Parameter(2)
    public String version;
	
	@Before
	public void before() throws MalformedURLException {
		driver = WebDriverUtils.create(platform, browser, version);
		driver.get("http://opencart.abstracta.us/");
	}
	
	@After
	public void after() {
		WebDriverUtils.quit(driver);
	}
	
	@Test
	public void signUpTest() {
		
	}
	
}
