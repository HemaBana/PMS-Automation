package generic;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.LoginPage;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
 
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;





public class BaseTest implements IAutoConst {
 public static WebDriver driver;
 /*static{
  System.setProperty(CHROME_KEY,CHROME_VALUE);
  System.setProperty(GECKO_KEY,GECKO_VALUE);
 }*/
 
 //@Parameters({"node","browser"})
 @BeforeSuite
 public void openApplication()
 {
	 System.setProperty("webdriver.chrome.driver","./driver/chromedriver_new.exe");
   driver=new ChromeDriver();
  String url=Lib.getProperty(CONFIG_PATH,"URL");
  driver.get(url);

    
 }
 
 
@Test
		public void testLogin() throws InterruptedException{
			String un=Lib.getCellValue(IAutoConst.XLPATH,"ValidLogin",1,0);
			String pw=Lib.getCellValue(IAutoConst.XLPATH,"ValidLogin",1,1);
			//String title=Lib.getCellValue(IAutoConst.XLPATH,"ValidLogin",1,2);
			LoginPage l=new LoginPage(driver);
			l.setUserName(un);
			Thread.sleep(2000);
			l.clickNext();
			Thread.sleep(2000);
			l.setPassword(pw);
			l.clickLogin();
			l.clickSign();
			Thread.sleep(5000);
		
		
			WebElement Partice = driver.findElement(By.xpath("//select[contains(@ng-options,'PracticeId')]"));
			Select select1=new Select(Partice);
		    select1.selectByIndex(1);
			
			

			Thread.sleep(8000);	
			
	
	/*	    
		driver.findElement(By.xpath("//option[contains(text(),'Omega')]")).click();
			 WebElement to1=driver.findElement(By.xpath("//div[contains(@class,'form')][2]"));
			    Actions action1=new Actions(driver);
				action1.moveToElement(to1).perform();
				Thread.sleep(8000);	*/
				
				WebElement Facility = driver.findElement(By.xpath("//select[contains(@ng-options,'BusinessUnitId')]"));
			  	Select select2=new Select(Facility);
			    select2.selectByIndex(1);
			    Thread.sleep(8000);	
			
			    WebElement Role = driver.findElement(By.xpath("//select[contains(@ng-options,'RoleId')]"));
			  	Select select3=new Select(Role);
			    select3.selectByIndex(1);
			    Thread.sleep(5000);	
			    driver.findElement(By.xpath("//option[contains(text(),'Front')]")).click();
				driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
		
 
		}
 
//@AfterMethod
/* public void closeApplication(ITestResult result) 
{
	String testName=result.getName();
	int status=result.getStatus();
	if(status==ITestResult.FAILURE)
	{
		Lib.getSnapShot(driver,SNAP_PATH+testName);
	}
	
	 if (driver != null && ((RemoteWebDriver) driver).getSessionId()!= null && !result.isSuccess())
	 {
		 
	 }
	driver.close();
 }
*/
@AfterSuite

 public static void closeApplication()
 {
 driver.close();
 }
 
 
 
 public class GenerateExtentReport{
		ExtentHtmlReporter htmlReporter;
		ExtentReports extent;
		ExtentTest logger;
		
		
		@BeforeTest
		public void startReport(){
			
			htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/STMExtentReport.html");
			extent = new ExtentReports ();
			extent.attachReporter(htmlReporter);
			extent.setSystemInfo("Host Name", "Name");
			extent.setSystemInfo("Environment", "Automation Testing");
			extent.setSystemInfo("User Name", "Hema");
			
			htmlReporter.config().setDocumentTitle("Automation Testing");
			htmlReporter.config().setReportName("Automation Testing");
			htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
			htmlReporter.config().setTheme(Theme.STANDARD);
		}
			
	    @Test
		public void passTest(){
			logger = extent.createTest("passTest");
			Assert.assertTrue(true);
			logger.log(Status.PASS, MarkupHelper.createLabel("Test Case Passed is passTest", ExtentColor.GREEN));
		}
		
		@Test
		public void failTest(){
			logger = extent.createTest("failTest");
			Assert.assertTrue(false);
			logger.log(Status.PASS, "Test Case (failTest) Status is passed");
			logger.log(Status.PASS, MarkupHelper.createLabel("Test Case (failTest) Status is passed", ExtentColor.GREEN));
		}
		
		@Test
		public void skipTest(){
			logger = extent.createTest("skipTest");
			throw new SkipException("Skipping - This is not ready for testing ");
		}
		
		@AfterMethod
		public void getResult(ITestResult result){
			if(result.getStatus() == ITestResult.FAILURE){
				//logger.log(Status.FAIL, "Test Case Failed is "+result.getName());
				//MarkupHelper is used to display the output in different colors
				logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
				logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
			}else if(result.getStatus() == ITestResult.SKIP){
				//logger.log(Status.SKIP, "Test Case Skipped is "+result.getName());
				logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));	
			}
		}
		@AfterTest
		public void endReport(){
			extent.flush();
	    }
	}

}


