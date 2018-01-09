package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	@FindBy(xpath="//input[@id='AuthenticationFG.USER_PRINCIPAL']")
	public   WebElement textUserName;
	
	
	@FindBy(xpath="//input[@id='AuthenticationFG.ACCESS_CODE']")
	public   WebElement textPassword;
	
	@FindBy(xpath="	//input[@id='VALIDATE_CREDENTIALS1']")
	public   WebElement buttonLogin;
	
	
	@FindBy(xpath="//input[@id='RETURN_TO_PROFILE']")
	public   WebElement buttonContinue;
	
}
