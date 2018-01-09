package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AadarUpdatationpage {

	
	
	@FindBy(xpath="//input[@id='AADHAAR_REMIND_LINKED']")
	public   WebElement buttonRemaindMeLater;

	
	
	@FindBy(xpath="//input[@id='AADHAARCHECK']")
	public   WebElement checkBoxReturnToProfile;
	
	@FindBy(xpath="//input[@id='RETURN_TO_PROFILE']")
	public   WebElement buttonContinue;
	
	@FindBy(xpath="//li[@id='INVESTMENTS__INSURANCE']")
	public   WebElement tabInvestmentInsurance;

	@FindBy(xpath="//a[@id='iWish-Flexible-RD']")
	public   WebElement submenuIwishFlexible;
	
	
	
}
