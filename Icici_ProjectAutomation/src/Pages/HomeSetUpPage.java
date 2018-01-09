package Pages;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class HomeSetUpPage  {
String url = "https://www.icicibank.com/safe-online-banking/safe-online-banking.page?";
	
	public WebDriver driver;

	
	@BeforeClass
	public void SetUp()  {
	
		System.setProperty("webdriver.ie.driver", "D:\\selenium jars\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	@AfterClass
	public void End() {

		driver.close();
	}
}
