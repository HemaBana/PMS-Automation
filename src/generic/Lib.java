package generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;



public class Lib {
	public static String getCellValue(String xlPath,String sheet,int r,int c){
		String v="";
		try{
			Workbook wb = WorkbookFactory.create(new FileInputStream(xlPath));
			v=wb.getSheet(sheet).getRow(r).getCell(c).toString();
		}
		catch(Exception e){
		}
		
		return v;
	}

	public static int getRowcount(String xlPath,String sheet){
		int rc=0;
		try{
			Workbook wb = WorkbookFactory.create(new FileInputStream(xlPath));
			rc=wb.getSheet(sheet).getLastRowNum();
		}
		catch(Exception e){
		}
		return rc;
	}
	
	public static String getProperty(String path,String key){
		String value="";
		try{
			Properties p=new Properties();
			p.load(new FileInputStream(path));
			value= p.getProperty(key);
		}
		catch(Exception e){
		}
		return value;
	}
	
	
	public static void getSnapShot(WebDriver driver,String folder,String Name)
		{
		   
			Date d=new Date();
			String now=Name+d.toString().replace(':', '-');
			TakesScreenshot t=(TakesScreenshot)driver;
			File srcFile= t.getScreenshotAs(OutputType.FILE);
			File destFile=new File("./Snap/"+now+".png");
			try
			{
				
				FileUtils.copyFile(srcFile, destFile);
			}
			
			catch(Exception e)
			{
				
			}
		}

	
	
	
	/*public static void getSnapShot1(ITestResult result)
	{
		String testName=result.getName();
		int status=result.getStatus();
		if(status==ITestResult.FAILURE)
		{
		
			ITestResult driver = null;
			Lib.getSnapShot1(driver);
		}*/
	
	public static void isElementPresent(WebElement elementName, int timeout)
	 {
	        try{
	            WebDriver driver = null;
				WebDriverWait wait = new WebDriverWait(driver, timeout);
	            wait.until(ExpectedConditions.visibilityOf(elementName));
	         
	        }
	        catch(Exception e)
	        {
	           
	        }
	    }
	
	
	}



		




