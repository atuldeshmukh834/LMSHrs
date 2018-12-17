package pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	
	// public static String usernamE;
	// public static String passworD;

	/*
	 * String username ="atul.deshmukh"; String password="oct#2018";
	 */

	@FindBy(xpath = "//*[@id='username']")
	WebElement Username;

	@FindBy(xpath = "//*[@id='passname']")
	WebElement txtFieldPassword;

	@FindBy(xpath = "//*[@class='loginbtn']")
	WebElement loginButton;

	// logout page
	@FindBy(xpath = "//*[@class='common-block user-designation']")
	WebElement Empname;

	@FindBy(xpath = "//a[contains(@href,'logout')]")
	WebElement logoutButton;

	public void login(String userName, String Password) throws InterruptedException {
		// username = usernamE;
		// password = passworD;
		Assert.assertTrue(waitForVisibilityOf(Username), "Login Page is not displayed");
		System.out.println("Login Page displayed");
		// waitForVisibilityOf(username);
		Username.sendKeys(userName);
		txtFieldPassword.sendKeys(Password);
		loginButton.click();
		Thread.sleep(2000);
	}

	public void logout() throws InterruptedException {
		/*
		 * waitFor(5000); Assert.assertTrue(waitForVisibilityOf(Empname),
		 * "Logout link is opened");
		 * System.out.println("User is logout successfully from Qtest");
		 * waitForVisibilityOf(username);
		 */
		Assert.assertTrue(waitForVisibilityOf(Empname), "Logout link is opened");
		System.out.println("User is logout successfully from LMS Application");
		Empname.click();
		Thread.sleep(2000);
		logoutButton.click();
		// driver.findElement(By.id("userName")).sendKeys("abc");

	}
	
 

}