package pages;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelRead {
	@Test
	  public void ReadExcel() throws Exception {
		  File src = new File("D:\\Basics\\Qtest\\RegressionCount_Status.xlsx");
	  	
	  	  FileInputStream FIS = new FileInputStream(src);
	  	
	  	  XSSFWorkbook wb = new XSSFWorkbook(FIS);
	  	
	  	 // XSSFSheet Sheet1 = wb.getSheetAt(0);
	  	  XSSFSheet Sheet1 = wb.getSheet("Sprintdata");
	  	  System.out.println("The Sheet1 Name :"+Sheet1);
	  	  
	  	  String Data0 = Sheet1.getRow(0).getCell(0).getStringCellValue();
	  	 System.out.println("Print the data from Excel----"+Data0);
	  	
	  	  String Data1 = Sheet1.getRow(1).getCell(0).getStringCellValue();
	  	
	  	  System.out.println("Print the data from Excel----"+Data1);
	  	  
	  	  String Data2 = Sheet1.getRow(1).getCell(1).getStringCellValue();
	  	
		  System.out.println("Print the data from Excel----"+Data2);
		  
		  wb.close();
	  }
}
