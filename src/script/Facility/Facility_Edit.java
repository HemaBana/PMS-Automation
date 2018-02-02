package script.Facility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import generic.IAutoConst;
import generic.Lib;
import pages.Facilities;

public class Facility_Edit extends Facility_Add{
	@Test(priority=2)
	public void testFacility_Edit() throws InterruptedException{
	
	    String N1=Lib.getCellValue(IAutoConst.XLPATH,"Facility_Edit",1,0);
		String P1=Lib.getCellValue(IAutoConst.XLPATH,"Facility_Edit",1,1);
		String E1=Lib.getCellValue(IAutoConst.XLPATH,"Facility_Edit",1,2);
	    String Hol=Lib.getCellValue(IAutoConst.XLPATH,"SetWorkHours_Edit",1,0);
		   
		Facilities f=new Facilities(driver);
		Thread.sleep(3000);
	
	f.clickEdit();
	driver.findElement(By.xpath("//input[@name='name']")).clear(); 
	f.setName(N1);
	driver.findElement(By.xpath("//input[@name='phone']")).clear();
     f.setPhone(P1);
     driver.findElement(By.xpath("//input[@name='email']")).clear();
     f.setEmail(E1);
    
     WebElement Pos = driver.findElement(By.name("pos"));
   	 Select select1=new Select(Pos);
     select1.selectByIndex(3);
    
 
   Thread.sleep(2000);

	f.clicksave();
	
	 String message=driver.findElement(By.xpath(".//*[@id='toast-container']/div/div/div")).getText();
	 System.out.println(message);

	Thread.sleep(2000);

	f.clickWorkHours();

	f.clickEditHoliday();
	
	Thread.sleep(2000);
	f.clickcalendericon();
	f.clickselectDate();
	f.setEnterHoliday(Hol);
	Thread.sleep(2000);
	f.clickSaveButton();
	Thread.sleep(2000);
	 String message1=driver.findElement(By.xpath(".//*[@id='toast-container']/div/div/div")).getText();
	 System.out.println(message1);
	Thread.sleep(2000);
	driver.findElement(By.xpath(".//*[@id='mainView']/section[2]/div/div/div/button")).click();
	
	String aFacilityName=driver.findElement(By.xpath("(//td[@class='ng-binding'])[1]")).getText();
	String eFacilityName="AppolloNew2";
	  
	Assert.assertEquals(aFacilityName, eFacilityName);
	System.out.println("Facility Details Edited Successfully");

	
}

}