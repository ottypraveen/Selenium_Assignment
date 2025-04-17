package standAlone;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import BaseTest.BaseTest;
import PageObjects.LandingPage;
import PageObjects.ProductCatalogue;
import PageObjects.cartPage;
import PageObjects.checkOutPage;
import PageObjects.confirmationPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class standAloneTest extends BaseTest {
	
	
	
	public WebDriver driver;
	@Test
	public void TestCase() throws InterruptedException, IOException
	{
		String productName = "ADIDAS ORIGINAL";
		driver=launchURL();
		
		/*
		 * ChromeOptions options = new ChromeOptions();
		 * options.addArguments("--remote-allow-origins=*");
		 * WebDriverManager.chromedriver().setup(); WebDriver driver=new
		 * ChromeDriver(options);
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 * driver.manage().window().maximize();
		 * driver.get("https://rahulshettyacademy.com/client");
		 */
		  
		LandingPage landingPage=new LandingPage(driver);
		landingPage.loginApplication("abc.klm@gmail.com", "abcklm");
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.AddtoCart(productName);
		productCatalogue.goToCart();
		cartPage cart = new cartPage(driver);
		cart.MatchProductsfromCart(productName);
		cart.clickCheckOutButton();
		checkOutPage checkOutPage1 = new checkOutPage(driver);
		checkOutPage1.placeOrder("India");
		confirmationPage confirmationPage1 = new confirmationPage(driver);
		confirmationPage1.verifyConfirmationMessage("THANKYOU FOR THE ORDER.");
		Thread.sleep(3000);

		/*
		 * 
		 * 
		 * //Login and Land onLanding Page
		 * driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys(
		 * "abc.klm@gmail.com");
		 * driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys("abcklm"
		 * ); driver.findElement(By.xpath("//input[@type='submit']")).click();
		 * 
		 * Thread.sleep(6000);
		 * 
		 * 
		 * WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
		 * ".mb-3"))); List<WebElement> products =
		 * driver.findElements(By.cssSelector(".mb-3"));
		 * 
		 * WebElement prod = products.stream().filter(product->
		 * product.findElement(By.cssSelector("b")).getText().equals("ADIDAS ORIGINAL"))
		 * .findFirst().orElse(null);
		 * prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		 * wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.
		 * cssSelector(".ng-animating")))); Thread.sleep(5000);
		 * driver.findElement(By.xpath("//li/button[contains(.,'Cart')]")).click();
		 * 
		 * Thread.sleep(5000);
		 * 
		 * //Verify the Products are matching
		 * 
		 * List <WebElement> cartProducts =
		 * driver.findElements(By.cssSelector(".cartSection h3")); Boolean match =
		 * cartProducts.stream().anyMatch(cartProduct->
		 * cartProduct.getText().equalsIgnoreCase(productName));
		 * Assert.assertTrue(match);
		 * 
		 * //click on CheckOut
		 * driver.findElement(By.xpath("//button[.='Checkout']")).click();
		 * 
		 * 
		 * //driver.findElement(By.xpath("//input[@placeholder='Select Country']")).
		 * sendKeys("Ind"); Thread.sleep(5000); Actions a = new Actions(driver);
		 * a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']"
		 * )), "india").build().perform();
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
		 * ".ta-results")));
		 * driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).
		 * click();
		 * driver.findElement(By.xpath("//a[normalize-space(.)='Place Order']")).click()
		 * ; String confirmMessage =
		 * driver.findElement(By.cssSelector(".hero-primary")).getText();
		 * Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."))
		 * ;
		 */
		driver.quit();
	}

	
}
