package tests;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import pages.LoginPage;

public class LMSTestBase {

	WebDriver driver;
	String classpathRoot;
	static XSSFWorkbook book;
	
	//static String username = LoginPage.username;
	
	
	@BeforeTest
    public void setUp()
    {
		System.setProperty("webdriver.chrome.driver", "D:/ATUL/Backup/Basics/Driver/chromedriver.exe");

		ChromeOptions options = new ChromeOptions();

		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		// driver.manage().deleteCookieNamed("https://sandc.qtestnet.com");
		driver.get("https://lms.infogain.com:8090/lms/login");
	    
	     
	     
    }
	
	@AfterTest
    public void End() throws Exception {
        driver.quit();
    
    }
	/*@AfterSuite
	 public void DeleteFirstsheet() throws IOException{
			
			String Filename = "D:\\ATUL\\Backup\\Basics\\LMS2\\TestData.xlsx";
			File file = new File(Filename);
			
			book = new XSSFWorkbook();
			FileOutputStream fileOut = new FileOutputStream("D:\\ATUL\\Backup\\Basics\\LMS2\\TestData.xlsx");
			
			//org.apache.poi.ss.usermodel.Sheet sh1 = workbook.createSheet("Sheet0");
			 XSSFSheet Sheet1 = book.getSheet("Sheet0");
			
	            if(Sheet1.getSheetName().equals("Sheet0")){
	                book.removeSheetAt(0);
	            }     
			
			book.write(fileOut);
			fileOut.close();

		}
*/
}
