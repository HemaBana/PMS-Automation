package script;


import org.openqa.selenium.By;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.IAutoConst;
import generic.Lib;
import pages.Facilities;

public class Facility_Add extends BaseTest{
	@Test(priority=2)
	public void testFacility_Add() throws InterruptedException{
	
	    String N1=Lib.getCellValue(IAutoConst.XLPATH,"Facility_Add",1,0);
		String P1=Lib.getCellValue(IAutoConst.XLPATH,"Facility_Add",1,1);
		String E1=Lib.getCellValue(IAutoConst.XLPATH,"Facility_Add",1,2);
		String Add1=Lib.getCellValue(IAutoConst.XLPATH,"Facility_Add",1,3);
		String city=Lib.getCellValue(IAutoConst.XLPATH,"Facility_Add",1,4);
		String Zip=Lib.getCellValue(IAutoConst.XLPATH,"Facility_Add",1,5);
		//String Des=Lib.getCellValue(IAutoConst.XLPATH,"SetWorkHours",1,0);
		String Hol=Lib.getCellValue(IAutoConst.XLPATH,"SetWorkHours",1,0);
		   driver.manage().window().maximize();
		Facilities f=new Facilities(driver);
		Thread.sleep(5000);
	
	f.clicksettings();
    Thread.sleep(5000);	
	f.clicksecurity();
	Thread.sleep(5000);	
	f.clickFacilityTab();
	Thread.sleep(5000);
	driver.findElement(By.xpath("//i[text()='replay']")).click();
	f.clickAddFacIcon();
	Thread.sleep(5000);
	f.setName(N1);
     f.setPhone(P1);
     f.setEmail(E1);
     f.clickPracticeCheckbox();
     f.clickPos();
     f.clickPosselect();
     f.clickAddressplus();
     f.clickAddressType();
 	 f.clickAddressTypeSelect();
 	 f.clickAddressType();
 	 Thread.sleep(1000);
     f.setAddress1(Add1);
     f.setcity(city);
     f.clickstate();
     f.stateselect();
     f.setZipcode(Zip);
   Thread.sleep(5000);

	f.clicksave();

	Thread.sleep(5000);

	f.clickWorkHours();

	Thread.sleep(1000);
	f.clickCheckboxdays();
	Thread.sleep(5000);
	f.clickApplyBreaklink();
	Thread.sleep(5000);
	driver.findElement(By.xpath("(//i[contains(@class,'plus')])[5]")).click();
	//f.clickAddBreak();
	Thread.sleep(5000);
	driver.findElement(By.xpath("//input[@name='description']")).sendKeys("Break");
	//f.setDescription(Des);
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//button[@class='primary'])[3]")).click();
	Thread.sleep(2000);
	f.clickSaveBreak();
	Thread.sleep(5000);
	f.clickApplyButton();
	Thread.sleep(2000);
	f.clickplusHoliday();
	Thread.sleep(2000);
	f.clickcalendericon();
	f.clickselectDate();
	f.setEnterHoliday(Hol);
	Thread.sleep(2000);
	f.clickSaveButton();
	Thread.sleep(2000);
	f.clickCancelButton();
	
}

}