package script.ServiceManager;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.IAutoConst;
import generic.Lib;
import pages.ServiceManager;

public class Service_Add extends BaseTest{

	@Test(priority=1)
	public void testService_Add() throws InterruptedException{
		String code=Lib.getCellValue(IAutoConst.XLPATH,"Service_Addon",1,0);
		String descirtion=Lib.getCellValue(IAutoConst.XLPATH,"Service_Addon",1,1);
		
		ServiceManager s=new ServiceManager(driver);
		 driver.manage().window().maximize();
		Thread.sleep(5000);
       s.clicksettings();
	
	 Thread.sleep(2000);	
	
	 s.clickservice();
	Thread.sleep(2000);
	
	s.clickAddons();
	Thread.sleep(2000);
	
	s.clickplusicon();
	Thread.sleep(2000);
	
	s.setcode(code);
	s.setdescription(descirtion);
 s.clicksave();
 String message=driver.findElement(By.xpath(".//*[@id='toast-container']/div/div/div")).getText();
 System.out.println(message);
 
}

}

