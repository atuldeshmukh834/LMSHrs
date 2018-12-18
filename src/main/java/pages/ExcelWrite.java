package pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.apache.poi.hssf.usermodel.HSSFHeader;
import org.apache.poi.hssf.usermodel.HeaderFooter;
import org.apache.poi.hssf.util.HSSFColor.GREEN;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Header;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.xssf.usermodel.*; 
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ExcelWrite extends InOutTime {

	public ExcelWrite() {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	static XSSFRow row;
		 
	static XSSFCell cell;
	
	@Test
	public static void WriteExcel(ArrayList<String> Date, ArrayList<String> SwipeIN, ArrayList<String> SwipeOut,ArrayList<String> TotalHrs)
			throws Exception 
	{
		
		String Filename = "D:\\ATUL\\Backup\\Basics\\LMS2\\TestData.xlsx";
		File file = new File(Filename);

		FileInputStream fis = new FileInputStream(file);
		
		XSSFWorkbook workbook= new XSSFWorkbook(fis);

		 XSSFSheet sh1 = workbook.getSheet("Sheet0");
		 
		 //int row1 = sh1.getLastRowNum()+1;
		 
		 CellStyle Style = workbook.createCellStyle();
   	     Style.setBorderLeft(BorderStyle.MEDIUM);
         Style.setBorderRight(BorderStyle.MEDIUM);
         Style.setBorderTop(BorderStyle.MEDIUM);
         Style.setBorderBottom(BorderStyle.MEDIUM);
		
		
		//XSSFSheet sh1 = workbook.createSheet(firstName); 
		//sh1 = workbook.getSheet(firstName);
		//if(workbook.getNumberOfSheets()!=0)
		
		if(workbook.getNumberOfSheets()!=0){
			sh1 = workbook.createSheet(firstName);
			
			  Row header = sh1.createRow(0);
    		  XSSFCellStyle style = workbook.createCellStyle();
    		  
    		  XSSFFont font = workbook.createFont();
    		  font.setBold(true);
    		  style.setFont(font);
    		  font.setColor(XSSFFont.COLOR_RED);
 	   		  header.createCell(0).setCellValue("Date");
 	   		  header.createCell(1).setCellValue("Swipe - In");
 	   		  header.createCell(2).setCellValue("Swipe - Out");
 	   		  header.createCell(3).setCellValue("Total Hrs");
 	   		  style.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
 	   	      style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
 	   		  header.getCell(0).setCellStyle(style);
 	   		  header.getCell(1).setCellStyle(style);
 	   		  header.getCell(2).setCellStyle(style);
 	   	      header.getCell(3).setCellStyle(style);
 	   	      style.setBorderLeft(BorderStyle.MEDIUM);
 	   	      style.setBorderRight(BorderStyle.MEDIUM);
              style.setBorderTop(BorderStyle.MEDIUM);
              style.setBorderBottom(BorderStyle.MEDIUM);
			
	    	   for (int i = 1; i < Date.size()+1; i++) {
	    		
                  //cell.setCellStyle(Style);

	    		   
	   			row = sh1.createRow(i);
	   			 
	   			cell = row.createCell(0);
	   			cell.setCellValue(Date.get(i-1));
	   			/*//CellStyle Style = workbook.createCellStyle();  
	            Style.setBorderLeft(BorderStyle.MEDIUM);
	            Style.setBorderRight(BorderStyle.MEDIUM);
	            Style.setBorderTop(BorderStyle.MEDIUM);
	            Style.setBorderBottom(BorderStyle.MEDIUM);*/
	            cell.setCellStyle(Style);
			
	   			cell = row.createCell(1);
	   			cell.setCellValue(SwipeIN.get(i-1));
	            cell.setCellStyle(Style);
	            Style.setAlignment(HorizontalAlignment.CENTER);
	   			
	   			cell = row.createCell(2);
	   			cell.setCellValue(SwipeOut.get(i-1));
	            cell.setCellStyle(Style);
	   			
	   			cell = row.createCell(3);
	   			cell.setCellValue(TotalHrs.get(i-1));
	   			cell.setCellStyle(Style);
	   			
	   		/*	XSSFSheetConditionalFormatting my_cond_format_layer = sh1.getSheetConditionalFormatting();
	            XSSFConditionalFormattingRule my_rule = my_cond_format_layer.
	            		createConditionalFormattingRule(ComparisonOperator.LT, "21600");
	            XSSFFontFormatting my_rule_pattern = my_rule.createFontFormatting();
                my_rule_pattern.setFontColorIndex(IndexedColors.RED.getIndex());
                ConditionalFormattingRule [] multiple_rules = {my_rule};
                CellRangeAddress[] my_data_range = {CellRangeAddress.valueOf("D2:D30")};
                my_cond_format_layer.addConditionalFormatting(my_data_range,multiple_rules);*/
	   			
	   		}
	      }else{
	    	   sh1 = workbook.createSheet(firstName);
	    	      Row header = sh1.createRow(0);
	    		  XSSFCellStyle style = workbook.createCellStyle();
	    		  
	    		  XSSFFont font = workbook.createFont();
	    		  font.setBold(true);
	    		  style.setFont(font);
	    		  font.setColor(XSSFFont.COLOR_RED);
	 	   		  header.createCell(0).setCellValue("Date");
	 	   		  header.createCell(1).setCellValue("Swipe - In");
	 	   		  header.createCell(2).setCellValue("Swipe - Out");
	 	   		  header.createCell(3).setCellValue("Total Hrs");
	 	   		  style.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
	 	   	      style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	 	   		  header.getCell(0).setCellStyle(style);
	 	   		  header.getCell(1).setCellStyle(style);
	 	   		  header.getCell(2).setCellStyle(style);
	 	   	      header.getCell(3).setCellStyle(style);
	 	   	      style.setBorderLeft(BorderStyle.MEDIUM);
	 	   	      style.setBorderRight(BorderStyle.MEDIUM);
	              style.setBorderTop(BorderStyle.MEDIUM);
	              style.setBorderBottom(BorderStyle.MEDIUM);
	    	   
	    	   for (int i = 1; i < Date.size()+1; i++) {

	    		  /* Row header = sh1.createRow(0);
		    		  XSSFCellStyle style = workbook.createCellStyle();
		    		  
		    		  XSSFFont font = workbook.createFont();
		    		  font.setBold(true);
		    		  style.setFont(font);
		    		  font.setColor(XSSFFont.COLOR_RED);
		 	   		  header.createCell(0).setCellValue("Date");
		 	   		  header.createCell(1).setCellValue("Swipe - In");
		 	   		  header.createCell(2).setCellValue("Swipe - Out");
		 	   		  header.createCell(3).setCellValue("Total Hrs");
		 	   		  header.getCell(0).setCellStyle(style);
		 	   		  header.getCell(1).setCellStyle(style);
		 	   		  header.getCell(2).setCellStyle(style);
		 	   	      header.getCell(3).setCellStyle(style);
		 	   	      style.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
	 	   	          style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		 	   	      style.setBorderLeft(BorderStyle.MEDIUM);
	 	   	          style.setBorderRight(BorderStyle.MEDIUM);
	                  style.setBorderTop(BorderStyle.MEDIUM);
	                  style.setBorderBottom(BorderStyle.MEDIUM);*/
		 	   	      /*CellStyle Style = workbook.createCellStyle();
	 	   	          Style.setBorderLeft(BorderStyle.MEDIUM);
                      Style.setBorderRight(BorderStyle.MEDIUM);
                      Style.setBorderTop(BorderStyle.MEDIUM);
                      Style.setBorderBottom(BorderStyle.MEDIUM);
                      //cell.setCellStyle(Style);
*/	    		   
		   			row = sh1.createRow(i);
		   			 
		   			cell = row.createCell(0);
		   			cell.setCellValue(Date.get(i-1));
		   			//CellStyle Style = workbook.createCellStyle();  
		            /*Style.setBorderLeft(BorderStyle.MEDIUM);
		            Style.setBorderRight(BorderStyle.MEDIUM);
		            Style.setBorderTop(BorderStyle.MEDIUM);
		            Style.setBorderBottom(BorderStyle.MEDIUM);*/
		            cell.setCellStyle(Style);
		            
		   			cell = row.createCell(1);
		   			cell.setCellValue(SwipeIN.get(i-1));
		            cell.setCellStyle(Style);
		            Style.setAlignment(HorizontalAlignment.CENTER);
		           
		            
		   			cell = row.createCell(2);
		   			cell.setCellValue(SwipeOut.get(i-1));
		            cell.setCellStyle(Style);
		            
		   			cell = row.createCell(3);
		   			cell.setCellValue(TotalHrs.get(i-1));
		            cell.setCellStyle(Style);
		            
		            String time = TotalHrs();
		      	    String[] split = time.split(":"); 
		      	    if(split.length == 2) { 
		      	          long minutes = TimeUnit.HOURS.toMinutes(Integer.parseInt(split[0])) + 
		      	                           Integer.parseInt(split[1]);
		      	          System.out.println("Test"+minutes);
		      	      }
		   			
		            /*String Time=TotalHrs();
		   			Double Dvalue= Double.parseDouble(Time);
		   			System.out.println("Convert Total Hrs is"+Dvalue);
		   			
		            XSSFSheetConditionalFormatting my_cond_format_layer = sh1.getSheetConditionalFormatting();
		            XSSFConditionalFormattingRule my_rule = my_cond_format_layer.
		            		createConditionalFormattingRule(ComparisonOperator.LT, "5 : 30");
		            XSSFFontFormatting my_rule_pattern = my_rule.createFontFormatting();
	                my_rule_pattern.setFontColorIndex(IndexedColors.RED.getIndex());
	                ConditionalFormattingRule [] multiple_rules = {my_rule};
	                CellRangeAddress[] my_data_range = {CellRangeAddress.valueOf("D2:D30")};
	                my_cond_format_layer.addConditionalFormatting(my_data_range,multiple_rules);*/
	    	   }
	    	   
		}
	    	 FileOutputStream fout = new FileOutputStream("D:\\ATUL\\Backup\\Basics\\LMS2\\TestData.xlsx",false);

	   		// FileOutputStream fout=new FileOutputStream(new
	   		// File("D:\\ATUL\\Backup\\Basics\\LMS2\\LMSHrsCount_Status1.xlsx"));

	   		workbook.write(fout);

	   		// close the file

	   		fout.close();

        }     
}