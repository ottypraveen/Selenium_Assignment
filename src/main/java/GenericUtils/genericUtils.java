package GenericUtils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class genericUtils {
	
	
	WebDriver driver;
	
	@FindBy(xpath = "//li/button[contains(.,'Cart')]")
	WebElement cartHeader;
	
	
	public genericUtils(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	
	public void waitforelementtoAppear(By findBy) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

		
	}
	
	public void waitForElementToDisappear(WebElement ele) throws InterruptedException
	{
		Thread.sleep(1000);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
//		wait.until(ExpectedConditions.invisibilityOf(ele));

	}
	
	public void goToCart()
	{
		cartHeader.click();
	}
	
	
}
