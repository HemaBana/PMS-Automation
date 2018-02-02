package script.DocumentManagement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;



import script.Document_Upload;



public class Document_Patient extends Document_Add{
	@Test(priority=5)
public void testDocument_Patient() throws InterruptedException{
	
		
		
		Thread.sleep(7000);
       
		WebElement a =driver.findElement(By.xpath(".//*[@id='container']/header/div[2]/div[2]/div/input"));
        a.sendKeys("Lin");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[contains(text(),'Linda Mark')]")).click();
        Thread.sleep(3000);
        WebElement PatListBox = driver.findElement(By.xpath(".//*[@id='statusIndicator']/select"));
    	Select select=new Select(PatListBox);
    	select.selectByValue("6");
    	Thread.sleep(3000);
    	
    	String aFileName=driver.findElement(By.xpath("(//a[contains(@class,'pointer ')])[1]")).getText();
  	    String eFileName="Upload";
  	  
  	  Assert.assertEquals(aFileName, eFileName);

	}
}