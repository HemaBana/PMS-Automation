package script.DomainValues;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import generic.IAutoConst;
import generic.Lib;
import pages.DomainValues;

public class Domain_Edit extends Domain_Add{
	@Test(priority=3)
	public void testDomain_Edit() throws InterruptedException{
		String v1=Lib.getCellValue(IAutoConst.XLPATH,"Domain_Edit",1,0);
		String C1=Lib.getCellValue(IAutoConst.XLPATH,"Domain_Edit",1,1);
		
		DomainValues d=new DomainValues(driver);
		
		Thread.sleep(3000);
	
	d.clickEdit();
	
	driver.findElement(By.xpath("//input[@name='domainValue']")).clear(); 
	
	d.setValue(v1);
	WebElement CS = driver.findElement(By.name("codeSystem"));
  	Select select1=new Select(CS);
    select1.selectByIndex(2);
    
    driver.findElement(By.xpath("//input[@name='code']")).clear(); 
  	d.setCode(C1);
  	Thread.sleep(3000);
  	driver.findElement(By.xpath("(//div[@class='md-bar'])[2]")).click();
  	driver.findElement(By.xpath("//span[text()='Ok']")).click();
	Thread.sleep(3000);
   d.clicksave();
   String message=driver.findElement(By.xpath(".//*[@id='toast-container']/div/div/div")).getText();
   System.out.println(message);
 
}

}
