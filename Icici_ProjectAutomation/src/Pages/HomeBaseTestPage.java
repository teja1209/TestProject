package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomeBaseTestPage {
	@FindBy(xpath="//a[text()='Continue to Login']")
	private   WebElement buttonContinueToLogin;
}
