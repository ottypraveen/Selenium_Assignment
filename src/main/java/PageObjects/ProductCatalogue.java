package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtils.genericUtils;

public class ProductCatalogue extends genericUtils {
	
	WebDriver driver;
	
	
	public ProductCatalogue(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	//WebElement userEmail=driver.findElement(By.xpath("//input[@id='userEmail']"));
	
	@FindBy(css=".mb-3")
	private List<WebElement> elements;
	
	@FindBy(css = ".ng-animating")
	WebElement spinner;
	
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastMessage = By.cssSelector("#toast-container");
	By productBy=By.cssSelector(".mb-3");

	
	public List<WebElement> getProductList()
	{
		waitforelementtoAppear(productBy);
		return  elements;
	}
	
	public WebElement getProductByName(String productName)
	{
		WebElement prod =	getProductList().stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
		
	}
	
	public void AddtoCart(String product) throws InterruptedException
	{
		getProductByName(product).findElement(addToCart).click();
		waitforelementtoAppear(toastMessage);
		waitForElementToDisappear(spinner);
		
	}
	
	
	
	
	
	

}
