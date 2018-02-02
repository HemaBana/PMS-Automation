package script;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.IAutoConst;
import generic.Lib;
import pages.ChargeMaster;


public class Charge_Add extends BaseTest{
	@Test(priority=2)
	public void testCharge_Add() throws InterruptedException{
		String c1=Lib.getCellValue(IAutoConst.XLPATH,"Charge_Add",1,0);
		String d1=Lib.getCellValue(IAutoConst.XLPATH,"Charge_Add",1,1);
		String DC=Lib.getCellValue(IAutoConst.XLPATH,"Charge_Add",1,2);
		String P1=Lib.getCellValue(IAutoConst.XLPATH,"Charge_Add",1,3);
		String A1=Lib.getCellValue(IAutoConst.XLPATH,"Charge_Add",1,4);
		
		ChargeMaster c =new ChargeMaster(driver);
		 driver.manage().window().maximize();
		Thread.sleep(5000);
        c.clicksettings();
        c.clickservicetab();
        c.clickCPT();
        Thread.sleep(3000);
        c.clickplusicon();
        c.setcode(c1);
        c.setdescription(d1);
        c.setDefaultCharge(DC);
        
        
        
        WebElement Cs1 = driver.findElement(By.name("codeSystem"));
      	Select select1=new Select(Cs1);
      	select1.selectByVisibleText("CPT");
      	c.clicksave();
      	c.clickChargeMaster();
      	Thread.sleep(3000);
      	c.clickChargeMasterPlusIcon();
      	Thread.sleep(3000);
      	
      	driver.findElement(By.xpath("//input[@name='code']")).sendKeys("890899");
      	Thread.sleep(5000);
    	driver.findElement(By.xpath("//span[@class='highlight']")).click();
    	c.clicksaveChargeMaster();
    	Thread.sleep(5000);
    	c.clickChargeMasterclick();
    	Thread.sleep(5000);
    	c.clickPayerplusicon();
    	 WebElement Payer = driver.findElement(By.name("payerName"));
       	Select select2=new Select(Payer);
       	select2.selectByIndex(1);
       	c.setPlanName(P1);
       	c.setAmount(A1);
       	c.clickSavePayer();
    	}
}