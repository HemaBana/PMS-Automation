package script.Scheduling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import generic.IAutoConst;
import generic.Lib;
import pages.LoginPage;
import pages.Scheduling;
import pages.SuperBill;

public class DayView
{
	public static WebDriver driver=null;

@Test(priority=2)

	public void testDayView() throws InterruptedException{
	 driver=new ChromeDriver();
	 System.setProperty("webdriver.chrome.driver","./driver/chromedriver_new.exe");
	   driver=new ChromeDriver();
	  String url=Lib.getProperty("./config.properties","URL");
	  driver.get(url);
	 String un=Lib.getCellValue(IAutoConst.XLPATH,"ValidLogin",1,0);
		String pw=Lib.getCellValue(IAutoConst.XLPATH,"ValidLogin",1,1);
		//String title=Lib.getCellValue(IAutoConst.XLPATH,"ValidLogin",1,2);
		LoginPage l=new LoginPage(driver);
		l.setUserName(un);
		Thread.sleep(3000);
		l.clickNext();
		Thread.sleep(3000);
		l.setPassword(pw);
		l.clickLogin();
		l.clickSign();
		Thread.sleep(7000);
		WebElement Partice = driver.findElement(By.xpath("//select[contains(@ng-options,'PracticeId')]"));
		Select select1=new Select(Partice);
	    select1.selectByIndex(1);
		
		

		Thread.sleep(8000);	
		


			
			WebElement Facility = driver.findElement(By.xpath("//select[contains(@ng-options,'BusinessUnitId')]"));
		  	Select select2=new Select(Facility);
		    select2.selectByIndex(1);
		    Thread.sleep(8000);	
		
		    WebElement Role = driver.findElement(By.xpath("//select[contains(@ng-options,'RoleId')]"));
		  	Select select3=new Select(Role);
		    select3.selectByIndex(1);
		    Thread.sleep(5000);	
		    driver.findElement(By.xpath("//option[contains(text(),'Front')]")).click();
			driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
			
		 Scheduling	 sd =new Scheduling(driver);
		 
	
			

	}
}
		