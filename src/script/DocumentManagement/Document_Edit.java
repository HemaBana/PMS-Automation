package script.DocumentManagement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import generic.IAutoConst;
import generic.Lib;
import pages.DocumentManagement;
import pages.LoginPage;



public class Document_Edit 
{
	public static WebDriver driver=null;

@Test(priority=3)

	public void testDocument_Edit() throws InterruptedException{
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
		
	
		
		
WebElement to=driver.findElement(By.xpath("//div[contains(@class,'form')][1]"));
	    Actions action=new Actions(driver);
		action.moveToElement(to).perform();
		Thread.sleep(8000);	
		
		/*WebElement Practice = driver.findElement(By.xpath("//option[contains(text(),'Select a Practice')]"));
	  	Select select1=new Select(Practice);
	    select1.selectByIndex(1);*/
	    
	driver.findElement(By.xpath("//option[contains(text(),'Omega')]")).click();
		 WebElement to1=driver.findElement(By.xpath("//div[contains(@class,'form')][2]"));
		    Actions action1=new Actions(driver);
			action1.moveToElement(to1).perform();
			Thread.sleep(8000);	
			
			/*WebElement Facility = driver.findElement(By.xpath("//option[contains(text(),'Select a Facility')]"));
		  	Select select2=new Select(Facility);
		    select2.selectByIndex(1);
			*/
			driver.findElement(By.xpath("//option[text()='StarHealth']")).click();
			
		WebElement to2=driver.findElement(By.xpath("//div[contains(@class,'form')][3]"));
		    Actions action2=new Actions(driver);
			action2.moveToElement(to2).perform();
			Thread.sleep(8000);	
		    
		    
			driver.findElement(By.xpath("//option[contains(text(),'Front')]")).click();
			driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
	
			String F1=Lib.getCellValue(IAutoConst.XLPATH,"Document_Upload",1,0);
			String D1=Lib.getCellValue(IAutoConst.XLPATH,"Document_Upload",1,1);
			
			
			
	        
	  DocumentManagement d =new DocumentManagement(driver);
	  
	  driver.manage().window().maximize();
		Thread.sleep(5000);
      d.clickWorkplacetab();
      d.clickDocumentManagementTab();
		 
		Thread.sleep(7000);
        d.clickEditIcon();
		Thread.sleep(7000);
        driver.findElement(By.xpath("//input[@name='fileName']")).clear();
        
        driver.findElement(By.xpath("//input[@name='fileName']")).sendKeys("Filenew1");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//textarea[@name='description']")).clear();
        driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys("FileDescription1");
        Thread.sleep(5000);
        d.clickSaveButton();
        String message=driver.findElement(By.xpath("//div[@class='toast-message']")).getText();
	    System.out.println(message);
	
}
}
