package pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class WriteExcelData {
	
	@Test
	public void writeexcel() throws IOException{
			
	File src = new File("D:\\ATUL\\Backup\\Basics\\LMS2\\WorkingHrs.xlsx");
	
	FileInputStream fis=new FileInputStream(src);
	
	XSSFWorkbook wb=new XSSFWorkbook(fis);
	
	XSSFSheet sh1= wb.getSheetAt(0);
	
	sh1.getRow(0).createCell(2).setCellValue("2.41.0");

	sh1.getRow(1).createCell(2).setCellValue("2.5");

	sh1.getRow(2).createCell(2).setCellValue("2.39");

	FileOutputStream fout=new FileOutputStream(new File("D:\\ATUL\\Backup\\Basics\\LMS2\\WorkingHrs.xlsx"));


	// finally write content 

	wb.write(fout);

	// close the file

	fout.close();
	
	}

}
