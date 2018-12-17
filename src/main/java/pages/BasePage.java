package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	static WebDriver driver;
	
	public BasePage(WebDriver driver) {
        this.driver = driver;
    }




protected static void waitFor(long time) {
    try {
		Thread.sleep(time);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
}

protected boolean waitForVisibilityOf(WebElement element) {
    
	try {
	WebDriverWait wait = new WebDriverWait(driver, 30);
    wait.until(ExpectedConditions.visibilityOf(element));
    }
	catch(Exception e)
	{
		return false;
	}
	
	return true;
}


 }
