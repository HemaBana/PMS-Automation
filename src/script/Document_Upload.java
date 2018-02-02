package script;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.IAutoConst;
import generic.Lib;
import pages.DocumentManagement;


public class Document_Upload extends BaseTest {
	@Test(priority=2)
	public void testDocument_Upload() throws InterruptedException{
		String F1=Lib.getCellValue(IAutoConst.XLPATH,"Document_Upload",1,0);
		String D1=Lib.getCellValue(IAutoConst.XLPATH,"Document_Upload",1,1);
		
		DocumentManagement d =new DocumentManagement(driver);
		 driver.manage().window().maximize();
		Thread.sleep(5000);
        d.clickWorkplacetab();
        d.clickDocumentManagementTab();
        Thread.sleep(5000);
        d.clickUploadIcon();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='dmPatient']")).sendKeys("Lin");
        driver.findElement(By.xpath("//span[@class='highlight']")).click();
        WebElement ele=driver.findElement(By.name("file"));
    	ele.sendKeys("E:\\Authorized.png");
         Thread.sleep(2000);
        d.setFileName(F1);
        Thread.sleep(2000);
        d.setFileDescription(D1);
        Thread.sleep(2000);
	    d.clickUploadButton();
	    Thread.sleep(2000);
	
}
}