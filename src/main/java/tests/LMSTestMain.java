package tests;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.mail.EmailException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pages.InOutTime;
import pages.LoginPage;


public class LMSTestMain extends LMSTestBase{
	
	String firstName = InOutTime.firstName;

	@BeforeSuite
	public void DeleteFile() throws IOException{
		
		String Filename = "D:\\ATUL\\Backup\\Basics\\LMS2\\TestData.xlsx";
		File file = new File(Filename);
		
		if (file.exists()) {
		     file.delete();
		     System.out.println("Deleted");
		   }
		 file.createNewFile();
		 XSSFWorkbook workbook = new XSSFWorkbook();
		FileOutputStream fileOut = new FileOutputStream("D:\\ATUL\\Backup\\Basics\\LMS2\\TestData.xlsx");
		
		//org.apache.poi.ss.usermodel.Sheet sh1 = workbook.createSheet("Sheet0");
		workbook.write(fileOut);
		fileOut.close();

	}
	//String usernamE = LoginPage.usernamE;
	//String passworD = LoginPage.passworD;
	
	@Test(dataProvider="Authentication")
	
	public void LMS(String userName, String Password) throws InterruptedException, IOException
	{
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(userName,Password );
		InOutTime swipein = new InOutTime(driver);
		swipein.Inout();
		loginPage.logout();
		
	}
	
	@DataProvider(name = "Authentication")
    public Object[][] getData() throws IOException{
		 
		 FileInputStream fileInputStream = new FileInputStream("D:\\ATUL\\Backup\\Basics\\LMS2\\Data\\Data1.xlsx");
		 
		 XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
		 
		 XSSFSheet worksheet = workbook.getSheet("Sheet1");
		 XSSFRow Row=worksheet.getRow(0);
		 
		 int rownum = worksheet.getPhysicalNumberOfRows();
		 System.out.println(rownum);
		 
		 
		 
		 int ColNum= Row.getLastCellNum();
		 System.out.println(ColNum);// get last ColNum 
		 
		 Object [][] Data = new Object[rownum][ColNum];
		 
		 for(int i=0; i<rownum; i++){
			 
			 XSSFRow row = worksheet.getRow(i);
			 System.out.println(row);
			 
			 XSSFCell username = row.getCell(0);
			 if(username==null){
				 
			 Data[i][0] = "";
			 
			 } else
			 {
				 username.setCellType(CellType.STRING);
				 Data[i][0] = username.getStringCellValue();
			 }
			 
			 XSSFCell password = row.getCell(1);
			 if(password==null){
				 Data[i][1] = "";
			 }else{
				 password.setCellType(CellType.STRING);
				 Data[i][1] = password.getStringCellValue();
			 }
			
			 
		 }
		 
		 return Data;
		 
	 }

}

