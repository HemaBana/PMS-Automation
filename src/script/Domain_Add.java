package script;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.IAutoConst;
import generic.Lib;
import pages.DomainValues;

public class Domain_Add extends BaseTest{
	@Test(priority=2)
	public void testDomain_Add() throws InterruptedException{
		String v1=Lib.getCellValue(IAutoConst.XLPATH,"Domain_Add",1,0);
		
		
		DomainValues d=new DomainValues(driver);
		 driver.manage().window().maximize();
		Thread.sleep(5000);
	WebElement to4=driver.findElement(By.xpath("//span[text()='Settings']"));
    Actions action3=new Actions(driver);
	action3.moveToElement(to4).perform();
	//driver.findElement(By.xpath("//span[text()='Settings']")).click();	
	 Thread.sleep(7000);	
	//driver.findElement(By.xpath("//a[contains(text(),'Service')]")).click();
     d.clickDomain();
	Thread.sleep(8000);
	driver.findElement(By.xpath("//i[text()='replay']")).click();
	driver.findElement(By.xpath("//a[contains(text(),'Adjustment Code')]")).click();
	//d.clickAdjustmentCode();
	Thread.sleep(2000);
	//driver.findElement(By.xpath("//i[contains(@class,'plus')]")).click();
	d.clickplusicon();
	Thread.sleep(5000);
	//driver.findElement(By.xpath("//input[@name='code']")).sendKeys("345123");
	//driver.findElement(By.xpath("//input[@name='serviceManagerValue']")).sendKeys("ABCD");
	d.setValue(v1);
 d.clicksave();
}

}