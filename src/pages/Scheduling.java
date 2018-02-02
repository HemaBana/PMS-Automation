package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Scheduling extends LoginPage {
	@FindBy(xpath=".//*[@id='sidebar']/div/ul/li[2]/a")
	 private WebElement ScheduleTab;
	 
	 @FindBy(xpath="//a[text()='Calendar']")
	 private WebElement CalenderTab;
	 
	@FindBy(xpath="//p[contains(text(),'Johnson ')]")
	 private WebElement SelectProvider;

	 
	 
	 @FindBy(xpath="(//div[contains(@class,'dayview1 ')])[1]")
	 private WebElement DayView;
	 
	 
	 
     @FindBy(xpath="(//div[contains(@class,'dayview ')])[40]")
	 private WebElement Dateselect;
	 
	 @FindBy(xpath="//textarea[@name='reason']")
	 private WebElement Reason;
	 
	 
	 @FindBy(xpath="(//input[@name='reminder'])[1]")
	 private WebElement RadioButton;
	 
	 @FindBy(xpath="//button[text()='Save']")
	 private WebElement Save;
	 
	 @FindBy(xpath="//span[text()='Eligibility']")
	 private WebElement EligibilityTab;
	 
	 @FindBy(xpath="//button[text()='RaiseER']")
	 private WebElement RaiseER;
	 
	 @FindBy(xpath="//input[@name='payer']")
	 private WebElement PayerPopUp;
	 
	 @FindBy(xpath="//button[text()='Send']")
	 private WebElement Send;
	 
	 public  Scheduling(WebDriver driver)
	 {
		super(driver); 
	  PageFactory.initElements(driver,this);
	 }
	 
	 public void clickScheduleTab(){
		 ScheduleTab.click();

	 }
	 
	public void clickCalenderTab()
	 {
		CalenderTab.click();
	 }

	public void clickDateselect()
	 {

		Dateselect.click();
	 }

	public void setReason(String R1){
		Reason.sendKeys(R1);
	 }
	


	public void clickRadioButton()
	 {

		RadioButton.click();
	 }

	
	
	public void clickSave()
	 {

		Save.click();
	 }

	public void clickEligibilityTab()
	 {

		EligibilityTab.click();
	 }
	
	public void clickRaiseER()
	 {

		RaiseER.click();
	 }

	public void clickPayerPopUp()
	 {

		 PayerPopUp.click();
	 }

	public void clickSend()
	 {

		Send.click();
	 }
	public void clickSelectProvider()
	 {

		SelectProvider.click();
	 }
	public void clickDayView()
	 {

		DayView.click();
	 }
	
	
}