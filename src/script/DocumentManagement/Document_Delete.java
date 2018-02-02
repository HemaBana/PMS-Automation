package script.DocumentManagement;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import pages.DocumentManagement;

class Document_Delete extends Document_Edit  {
@Test(priority=4)
	public void testDocument_Delete() throws InterruptedException{
		
        DocumentManagement d =new DocumentManagement(driver);
		 
		Thread.sleep(5000);
        d.clickDeleteIcon();
    	Thread.sleep(3000);
        driver.findElement(By.xpath("//span[text()='Ok']")).click();
        String message=driver.findElement(By.xpath("//div[@class='toast-message']")).getText();
	    System.out.println(message);
	
	   
	
}
}