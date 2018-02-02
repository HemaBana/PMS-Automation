package script.DomainValues;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.IAutoConst;
import generic.Lib;
import pages.DomainValues;

public class Domain_Add extends BaseTest{
	

	@Test(priority=1)
	public void testDomain_Add() throws InterruptedException{
		String v1=Lib.getCellValue(IAutoConst.XLPATH,"Domain_Add",1,0);
		String C1=Lib.getCellValue(IAutoConst.XLPATH,"Domain_Add",1,1);
		
		
		DomainValues d=new DomainValues(driver);
		 driver.manage().window().maximize();
		Thread.sleep(2000);
		
		 
	  Lib.isElementPresent(d.settingstab1, 2000);
	  d.clicksettings();
	  
	 Lib.isElementPresent(d.DomainTab,2000);
	 
     d.clickDomain();
     
   Thread.sleep(5000);
     Lib.isElementPresent(d.ReplayIcon,4000);
     d.clickReplayIcon();
     
     
     Lib.isElementPresent(d.AdjustmentCode,2000);
	  d.clickAdjustmentCode();
	  
	  Thread.sleep(5000);
	 Lib.isElementPresent(d.plusicon,2000);
	 
	 d.clickplusicon();
	
	Lib.isElementPresent(d.value, 10);
	d.setValue(v1);
	
	WebElement CS = driver.findElement(By.name("codeSystem"));
  	Select select1=new Select(CS);
    select1.selectByIndex(1);
    
	Lib.isElementPresent(d.Code, 30);
  	 d.setCode(C1);
  	
     d.clicksave();
 
// String message=driver.findElement(By.xpath(".//*[@id='toast-container']/div/div/div")).getText();
 //System.out.println(message);
 
}

}