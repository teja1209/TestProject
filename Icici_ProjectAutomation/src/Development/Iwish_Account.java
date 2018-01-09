package Development;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import DataFiles.LoginData;
import Pages.AadarUpdatationpage;
import Pages.HomeBaseTestPage;
import Pages.HomeSetUpPage;
import Pages.LoginPage;

public class Iwish_Account extends HomeSetUpPage {
	@Test
	public void Tc_1() throws Exception {

		StringBuilder htmlStringBuilder = new StringBuilder();
		// append html header and title
		htmlStringBuilder.append("<html><head><title>Selenium Test </title></head>");
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		htmlStringBuilder.append("<h1>Exection Time:" + dateFormat.format(date) + "</h1>");
		// append body
		htmlStringBuilder.append("<body>");
		// append table
		htmlStringBuilder.append("<table border=\"1\" bordercolor=\"#000000\">");
		// append row
		htmlStringBuilder.append("<tr><td><b>TestId</b></td>" + "<td><b>TestName</b></td>" + "<td><b>TestResult</b>"
				+ "<td><b>Condition</b>" + "</td></tr>");

		if (driver.getCurrentUrl()
				.equalsIgnoreCase("https://www.icicibank.com/safe-online-banking/safe-online-banking.page?")) {
			htmlStringBuilder.append("<tr><td>001</td><td>browserLaunched</td><td>Passed</td></tr>");
		} else {
			htmlStringBuilder.append("<tr><td>001</td><td>browserLaunched</td><td>Failed</td></tr>");
driver.close();

		}
		HomeBaseTestPage basepage = PageFactory.initElements(driver, HomeBaseTestPage.class);
		Thread.sleep(30000);
		basepage.buttonContinueToLogin.click();
		Thread.sleep(3000);
		if (driver.getTitle().equalsIgnoreCase("Log in to Internet Banking")) {
			htmlStringBuilder.append("<tr><td>002</td><td>ClickedonContinuebutton</td><td>passed</td></tr>");
		} else {
			htmlStringBuilder.append("<tr><td>002</td><td>ClickedonContinuebutton</td><td>Failed</td></tr>");
			driver.close();

		}
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		Thread.sleep(30000);
		LoginData logindata = PageFactory.initElements(driver, LoginData.class);

		loginpage.textUserName.sendKeys(logindata.username);
		System.out.println(loginpage.textUserName.getAttribute("value"));
		Thread.sleep(30000);

		if (loginpage.textUserName.getAttribute("value").equalsIgnoreCase(logindata.username)) {
			htmlStringBuilder.append("<tr><td>003</td><td>userName entered </td><td>pased</td></tr>");

		} else {
			htmlStringBuilder.append("<tr><td>003</td><td>userName entered</td><td>Failed</td></tr>");
			driver.close();

		}
		loginpage.textPassword.sendKeys(logindata.password);
		if (loginpage.textPassword.getAttribute("value").equalsIgnoreCase(logindata.password)) {
			htmlStringBuilder.append("<tr><td>004</td><td>password entered </td><td>pased</td></tr>");

		} else {
			htmlStringBuilder.append("<tr><td>004</td><td>userName entered</td><td>Failed</td></tr>");
			driver.close();

		}
		Thread.sleep(25000);
		loginpage.buttonLogin.click();
		Thread.sleep(25000);

		if (driver.getTitle().contains("Aadhaar Updation")) {
			htmlStringBuilder.append("<tr><td>005</td><td>LoginSuccesfull</td><td>pased</td></tr>");

		} else {
			htmlStringBuilder.append("<tr><td>005</td><td>LoginSuccesfull</td><td>Failed</td></tr>");
			driver.close();

		}
		AadarUpdatationpage updatePage = PageFactory.initElements(driver, AadarUpdatationpage.class);
		updatePage.buttonRemaindMeLater.click();
		Thread.sleep(30000);
		if (updatePage.buttonContinue.isDisplayed()) {
			htmlStringBuilder.append("<tr><td>006</td><td>ClickedonRemaindMeLater</td><td>pased</td></tr>");

		} else {
			htmlStringBuilder.append("<tr><td>006</td><td>ClickedonRemaindMeLater</td><td>Failed</td></tr>");
			driver.close();

		}
		updatePage.checkBoxReturnToProfile.click();
		Thread.sleep(30000);
		if (updatePage.checkBoxReturnToProfile.isSelected()) {
			htmlStringBuilder.append("<tr><td>007</td><td>Checkbox is selected</td><td>pased</td></tr>");

		} else {
			htmlStringBuilder.append("<tr><td>007</td><td>Checkbox is selected</td><td>Failed</td></tr>");
			driver.close();

		}
	updatePage.buttonContinue.click();
	Thread.sleep(30000);
	if(driver.getTitle().equals("My View"))
	{
		htmlStringBuilder.append("<tr><td>008</td><td>Clicked on Continue</td><td>pased</td></tr>");

	}
	else
	{
		htmlStringBuilder.append("<tr><td>008</td><td>Clicked on Continue</td><td>Failed</td></tr>");
		driver.close();

	}
	updatePage.tabInvestmentInsurance.click();
	updatePage.submenuIwishFlexible.click();
	if(driver.getTitle().equals("iWish from ICICI Bank"))
	{
		htmlStringBuilder.append("<tr><td>009</td><td>navigared to iwishpage1</td><td>pased</td></tr>");

	}
	else
	{
		htmlStringBuilder.append("<tr><td>009</td><td>Clicked on Continue</td><td>Failed</td></tr>");
		driver.close();

	}
	htmlStringBuilder.append("</table></body></html>");
		try {
			WriteToFile(htmlStringBuilder.toString(), "Pass.html");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void WriteToFile(String fileContent, String fileName) throws IOException {
		String projectPath = System.getProperty("user.dir");
		String tempFile = projectPath + File.separator + fileName;
		File file = new File(tempFile);
		// if file does exists, then delete and create a new file
		if (file.exists()) {
			try {
				File newFileName = new File(projectPath + File.separator + "backup_" + fileName);
				file.renameTo(newFileName);
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// write to file with OutputStreamWriter
		OutputStream outputStream = new FileOutputStream(file.getAbsoluteFile());
		Writer writer = new OutputStreamWriter(outputStream);
		writer.write(fileContent);
		writer.close();

	}

}
