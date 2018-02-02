package script;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import generic.BaseTest;
import pages.AuthorizedRepresentative;



public class Authorized_Add extends BaseTest{
	@Test(priority=2)
public void testAuthorized_Add() throws InterruptedException{
		/*String F1=Lib.getCellValue(IAutoConst.XLPATH,"Document_Upload",1,0);
		String D1=Lib.getCellValue(IAutoConst.XLPATH,"Document_Upload",1,1);*/
		
		AuthorizedRepresentative au =new AuthorizedRepresentative(driver);
		 driver.manage().window().maximize();
		Thread.sleep(5000);
       
        WebElement a =driver.findElement(By.xpath("(//input[@type='text'])[1]"));
        a.sendKeys("Joh");
        driver.findElement(By.xpath("//a[contains(text(),'John Walker')]")).click();
        Thread.sleep(5000);
        WebElement PatListBox = driver.findElement(By.xpath(".//*[@id='statusIndicator']/select"));
    	Select select=new Select(PatListBox);
    	select.selectByValue("2");
    	Thread.sleep(3000);
    	au.clickPlusIcon();
    	driver.findElement(By.xpath("//input[@name='arPatient']")).sendKeys("cas");
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("//span[contains(text(),'Macline')]")).click();
    	WebElement Relation = driver.findElement(By.name("arRelationship"));
      	Select select1=new Select(Relation);
      	select1.selectByVisibleText("Legal Representative");
    	Thread.sleep(3000);
    	au.clickSaveButton();
      	
    	
    	

       
   
}
}