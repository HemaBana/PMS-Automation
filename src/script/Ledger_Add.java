package script;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.IAutoConst;
import generic.Lib;
import pages.LedgerPage;
import pages.SuperBillGrid;

public class Ledger_Add extends BaseTest{
	@Test(priority=2)
	public void testLedger_Add() throws InterruptedException{
		String U1=Lib.getCellValue(IAutoConst.XLPATH,"SuperBillGrid",1,0);
		String T1=Lib.getCellValue(IAutoConst.XLPATH,"SuperBillGrid",1,1);
		String S1=Lib.getCellValue(IAutoConst.XLPATH,"Ledger",1,0);
		
		
	    SuperBillGrid su =new SuperBillGrid(driver);
	    LedgerPage l =new  LedgerPage(driver);
		
		 driver.manage().window().maximize();
			Thread.sleep(5000);
	       
	        WebElement a11 =driver.findElement(By.xpath("(//input[@type='text'])[1]"));
	        a11.sendKeys("Mad");
	        driver.findElement(By.xpath("//a[contains(text(),'Maddy John')]")).click();
	        Thread.sleep(3000);
	        WebElement PatListBox = driver.findElement(By.xpath(".//*[@id='statusIndicator']/select"));
	    	Select select=new Select(PatListBox);
	    	select.selectByValue("5");
		Thread.sleep(5000);
		
	l.setSearch(S1);
	Thread.sleep(3000);
	l.clickExpand();
	Thread.sleep(3000);
	l.clickExpandService();
	Thread.sleep(3000);
	l.clickAddPayLink();
	Thread.sleep(3000);
		
        
        
        su.clickPatientSourceRadio();
        Thread.sleep(3000);
        su.clickPaymentDate();
        Thread.sleep(3000);
        su.clickSelectPaymentDate();
        Thread.sleep(3000);
     
       
        WebElement PM = driver.findElement(By.xpath("//select[@name='paymentMethod']"));
       	Select select5=new Select(PM);
       	select5.selectByIndex(2);
       	Thread.sleep(3000);
       	su.clickPaymentType();
       	driver.findElement(By.xpath("//input[@name='paymentAmount']")).clear();
       	driver.findElement(By.xpath("//input[@name='paymentAmount']")).sendKeys("3");
       	su.clickAddPaymentbutton();
     
}
}
