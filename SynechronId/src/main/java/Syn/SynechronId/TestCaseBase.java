package Syn.SynechronId;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;


public class TestCaseBase extends HomeBaseTestPage{
	
	
	
	@Test
	public void TestCase_1()
	{
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		TestCaseBase basepage = PageFactory.initElements(driver, TestCaseBase.class);
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		driver.findElement(By.xpath("//input[@name='UserName']")).sendKeys("raghavendra.Damaraju");
		driver.findElement(By.name("Password")).sendKeys("Syne3009");
		driver.findElement(By.xpath("//input[contains(@value,'Sign In')]")).click();
		try{
			Thread.sleep(30000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}