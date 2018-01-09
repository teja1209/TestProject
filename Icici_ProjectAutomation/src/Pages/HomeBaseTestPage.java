package Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeBaseTestPage extends HomeSetUpPage {
	@FindBy(xpath="//a[text()='Continue to Login']")
	public   WebElement buttonContinueToLogin;


}
