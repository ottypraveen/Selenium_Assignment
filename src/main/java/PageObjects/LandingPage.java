package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtils.genericUtils;

public class LandingPage extends genericUtils {
	
	WebDriver driver;
	
	
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	//WebElement userEmail=driver.findElement(By.xpath("//input[@id='userEmail']"));
	
	@FindBy(xpath="//input[@id='userEmail']")
	private WebElement userEmail;
	
	@FindBy(xpath="//input[@id='userPassword']")
	private WebElement passwordelement;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement loginButton;
	
	@FindBy(xpath="//div[text()='*Enter Valid Email']")
	private WebElement errorMessage;
	
	
	
	
	public void loginApplication(String userName, String Password)
	{
		userEmail.sendKeys(userName);
		passwordelement.sendKeys(Password);
		loginButton.click();
		
	}
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public String getErrorMessage()
	{
		return errorMessage.getText();
	}
	
	
	
	

}
