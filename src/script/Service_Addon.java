package script;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.IAutoConst;
import generic.Lib;
import pages.ServiceManager;

public class Service_Addon extends BaseTest{

	@Test(priority=2)
	public void testService_Addon() throws InterruptedException{
		String code=Lib.getCellValue(IAutoConst.XLPATH,"Service_Addon",1,0);
		String descirtion=Lib.getCellValue(IAutoConst.XLPATH,"Service_Addon",1,1);
		//String title=Lib.getCellValue(IAutoConst.XLPATH,"ValidLogin",1,2);
		ServiceManager s=new ServiceManager(driver);
		 driver.manage().window().maximize();
		Thread.sleep(5000);
       s.clicksettings();
	
	 Thread.sleep(7000);	
	//driver.findElement(By.xpath("//a[contains(text(),'Service')]")).click();
	 s.clickservice();
	Thread.sleep(5000);
	//driver.findElement(By.xpath("//a[contains(text(),'Addon')]")).click();
	s.clickAddons();
	Thread.sleep(2000);
	//driver.findElement(By.xpath("//i[contains(@class,'plus')]")).click();
	s.clickplusicon();
	Thread.sleep(5000);
	//driver.findElement(By.xpath("//input[@name='code']")).sendKeys("345123");
	//driver.findElement(By.xpath("//input[@name='serviceManagerValue']")).sendKeys("ABCD");
	s.setcode(code);
	s.setdescription(descirtion);
 s.clicksave();
}

}


