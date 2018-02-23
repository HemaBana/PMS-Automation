package script.Scheduling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import generic.IAutoConst;
import generic.Lib;
import pages.Eligibility;
import pages.LoginPage;
import pages.Scheduling;

public class DayView
{
	public static WebDriver driver=null;

@Test(priority=2)

	public void testDayView() throws InterruptedException{
	String R1=Lib.getCellValue(IAutoConst.XLPATH,"Eligibility",1,0);{
	 driver=new ChromeDriver();
	 System.setProperty("webdriver.chrome.driver","./driver/chromedriver_new.exe");
	   driver=new ChromeDriver();
	  String url=Lib.getProperty("./config.properties","URL");
	  driver.get(url);
	 String un=Lib.getCellValue(IAutoConst.XLPATH,"ValidLogin",1,0);
		String pw=Lib.getCellValue(IAutoConst.XLPATH,"ValidLogin",1,1);
	
		String R11=Lib.getCellValue(IAutoConst.XLPATH,"Eligibility",1,0);
		String R2=Lib.getCellValue(IAutoConst.XLPATH,"Scheduling",1,0);
		
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
		 sd.clickSelectProvider();
		 sd.clickDayView();
		 //SuperBill s =new SuperBill(driver);
	     //SuperBillGrid su =new SuperBillGrid(driver);
	     Actions act = new Actions(driver);
	     act.doubleClick(driver.findElement(By.xpath("(//div[contains(@class,'dayview')])[51]"))).build().perform();
	     Thread.sleep(7000);
	     
	     driver.findElement(By.xpath(".//*[@id='input-21']")).sendKeys("Jam");
	       Thread.sleep(7000);
	       driver.findElement(By.xpath("(//span[@class='highlight'])[2]")).click();
	        WebElement Room = driver.findElement(By.name("room"));
	       	Select select4=new Select(Room);
	       	select4.selectByIndex(1);
	        
	        WebElement Payer= driver.findElement(By.name("primaryPayer"));
	       	Select select5=new Select(Payer);
	       	select5.selectByVisibleText("Payer");
	       	
	        WebElement SecondayPayer= driver.findElement(By.name("SecondaryPayer"));
	       	Select selectA=new Select(SecondayPayer);
	       	selectA.selectByVisibleText("HealthCare");
	       	
	       	
	        WebElement duration= driver.findElement(By.name("duration"));
	       	Select select6=new Select(duration);
	       	select6.selectByIndex(1);
	       	
	       	WebElement AT= driver.findElement(By.name("appointmentType"));
	       	Select select7=new Select(AT);
	       	select7.selectByIndex(1);
	       	
	       	
	      	WebElement RF= driver.findElement(By.name("frequecy"));
	       	Select select8=new Select(RF);
	       	select8.selectByIndex(1);
	       	
	       	Eligibility e =new Eligibility (driver);
	       	e.setReason(R11);
	       	e.clickRadioButton();
	       	

	      	WebElement AS= driver.findElement(By.name("source"));
	       	Select select9=new Select(AS);
	       	select9.selectByIndex(1);
	       	e.clickSave();
	       	
	       	Thread.sleep(5000);
	        sd.clickSelectProvider();
	        driver.findElement(By.xpath("//p[contains(text()='James Bob')]")).click();
	        
	        sd.clickNoShow();
	        sd.setNoShowReason(R2);
	        sd.clickNoReasonSave();
	        
	        String acolor = driver.findElement(By.xpath("//p[contains(text()='James Bob')]")).getCssValue("color");
	        
	        
	    	String ecolor="#fff7d3";
	    	  
	    	Assert.assertEquals(acolor, ecolor);
	       
	    
	        
	        
	       	
	       	
	}
	       	
	}
}

	



		