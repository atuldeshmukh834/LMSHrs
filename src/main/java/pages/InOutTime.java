package pages;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InOutTime extends BasePage {

	static String Swipehrs;
	static String SwipehrsMin;
	static String SwipeOutHrs;
	static String SwipeOutMins;
	static String PreviousMonth;
	static String IN;
	public static String firstName;
	static String CurrentUsername;
	String SWIPEINTIME;
	String SWIPE_IN_TIME;
	
    static CharSequence LastMonth = "-11-";

	public InOutTime(WebDriver driver) {
		super(driver);

		PageFactory.initElements(driver, this);

	}
	/*
	 * @FindBy(xpath=
	 * "//tbody[@class='fc-body']//div[@class='fc-content-skeleton']//td[contains(@data-date,'-10-')]")
	 * List<WebElement> DateView;
	 * 
	 * @FindBy(xpath=
	 * "//tbody[@class='fc-body']//div[@class='fc-content-skeleton']//td[contains(@data-date,'-10-')]/ancestor::thead/following-sibling::tbody//span[@class='fc-title']")
	 * List<WebElement> Monthview;
	 */

	ArrayList<String> Test = new ArrayList<String>();
	ArrayList<String> Date = new ArrayList<String>();
	ArrayList<String> SwipeIN = new ArrayList<String>();
	ArrayList<String> SwipeOut = new ArrayList<String>();
	static ArrayList<String> TOTALHRS = new ArrayList<String>();

	@FindBy(xpath = "//div[@class='fc-center']")
	WebElement Month;

	@FindBy(xpath = "//span[@class='pull-left common-margin']//span[@class='common-block']")
	static WebElement Username;

	@FindBy(xpath = "//span[@class='pull-left common-margin']//span[@class='common-block user-designation']")
	static WebElement Empid;

	@FindBy(xpath = "//button[@class='fc-prev-button ui-button ui-state-default ui-corner-left ui-corner-right']")
	WebElement Previousbutton;

	public void Inout() {

		Previousbutton.click();

		PreviousMonth = Month.getText();

		//System.out.println("current month is " + PreviousMonth);

		/*
		 * for (WebElement D:DateView){ String Date=D.getText();
		 * System.out.println("Print the Datewise Day"+Date); } for(WebElement
		 * in : Monthview) { //
		 * System.out.println("Day info printed-"+e.getText()); String
		 * IN=in.getText();
		 */

		List<WebElement> list = driver.findElements(By.xpath("//div[@class='fc-bg']"));

		for (int i = 1; i <= list.size(); i++) {

			List<WebElement> list11 = driver.findElements(By.xpath("(//div[@class='fc-content-skeleton']//thead)[" + i + "]//td"));

			for (int j = 0; j < list11.size(); j++) {
				//System.out.println(list11.get(j).getAttribute("data-date"));

				// System.out.println("Print Date Array List"+Date);
				
				if ((list11.get(j).getAttribute("data-date").contains(LastMonth))) {
					
					Date.add(list11.get(j).getAttribute("data-date"));
					//System.out.println("Test"+Date);
				} else {
					//System.out.println();
				} 

				if (list11.get(j).getAttribute("data-date").contains(LastMonth)) {
					List<WebElement> list13 = driver.findElements(By.xpath("(//div[@class='fc-content-skeleton']//tbody)[" + i + "]//td"));
					IN = list13.get(j).getText();
					//System.out.println(IN);
					//Test.add(list13.get(j).getText());
					
					
						
	

					// ++++++IN Time Code ++++++++++++

					try {
						if (IN.contains(":")) {
						SWIPEINTIME = IN.substring(0, 5);
						//System.out.println("Swipe IN Time" + SWIPEINTIME);
						SwipeIN.add(SWIPEINTIME);
						
						}else{
							
							//System.out.println(IN);
							SwipeIN.add(IN);
							
						 }
						
					} catch (Exception e) {
						//System.out.println("Warning : No values is present in IN Time--Blank");
					}

					try {

						if (IN.contains(":")) {

							Swipehrs = IN.substring(0, 2);
							//System.out.println("Swipe hrs Time" + Swipehrs);
						}
					} catch (NumberFormatException ex) {
						//System.out.println("OH,holiday leave is 2 words");
					}
					try {
						if (IN.contains(":")) {
							SwipehrsMin = IN.substring(3, 5);
							//System.out.println("SwipehrsMin Time" + SwipehrsMin);
						}
					} catch (Exception e) {
						//System.out.println("Warning: no values present in Swipe In time");
					}

					// ------------IN Time Code Ends Here-----

					// =------------++Out Time ++-----------------
					try {
						if (IN.contains(":")) {
						String Out = IN.substring(8, 13);
						//System.out.println("Swipe OUT Time" + Out);
						SwipeOut.add(Out);
						}
						else{
							//System.out.println(IN);
							SwipeOut.add(IN);
						}
					} catch (Exception e) {
						//System.out.println("Warning: no values present in Out time");
					}

					try {
						if (IN.contains(":")) {

							SwipeOutHrs = IN.substring(8, 10);
							//System.out.println("SwipeOutHrs Time" + SwipeOutHrs);
							SwipeOutMins = IN.substring(11, 13);
							//System.out.println("SwipeOutMins Time" + SwipeOutMins);

							TotalHrs();
							TOTALHRS.add(TotalHrs());
						}
						else{
							//System.out.println(IN);
							TOTALHRS.add("");
						}
					} catch (NumberFormatException ex) {
						//System.out.println("OH,holiday leave is 2 words");
					}

				}

			}
		}

		// Method is for currentUsername

		Username();
		// =============================

		// Write excel function call
		ExcelWrite writeexc = new ExcelWrite();
		try {
			ExcelWrite.WriteExcel(Date, SwipeIN, SwipeOut,TOTALHRS);
			Date.clear();
			SwipeIN.clear();
			SwipeOut.clear();
			TOTALHRS.clear();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		System.out.println("END====");

	}

	public static String Username() {
		CurrentUsername = Username.getText();
		//System.out.println("Printing the Current Username--" + CurrentUsername);
		 int firstSpaceIndex = CurrentUsername.indexOf(" ");
		  firstName = CurrentUsername.substring(0, firstSpaceIndex);
		// System.out.println("Printing the Current Username--" + firstName);

		String EmpID = Empid.getText();
		//System.out.println("Printing the Employee ID Number --" + EmpID);
		return "" + CurrentUsername + "--" + EmpID;
	}

	public static String TotalHrs() {

		int pStartHour = Integer.parseInt(Swipehrs);
		int pEndHour = Integer.parseInt(SwipeOutHrs);
		int pStartMinutes = Integer.parseInt(SwipehrsMin);
		int pEndMinutes = Integer.parseInt(SwipeOutMins);
		int hours;

		hours = pEndHour - pStartHour;
		int minutes = ((60 - pStartMinutes) + pEndMinutes) - 60;
		if (minutes < 0) {
			hours--;
			minutes = 60 + minutes;
		}

		String format = String.format("%%0%dd", 2);
		//System.out.println("Total Hrs of --" + PreviousMonth + "---" + hours + " : " + minutes);
		if(minutes<10){
			return "" + hours + " : " + "0"+ minutes;
			}
		else{
				return "" + hours + " : " + minutes;
			}
		
		
	}
	

}
