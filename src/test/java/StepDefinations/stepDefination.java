package StepDefinations;

import java.io.IOException;
import java.time.Duration;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import BaseTest.BaseTest;
import PageObjects.LandingPage;
import PageObjects.ProductCatalogue;
import PageObjects.cartPage;
import PageObjects.checkOutPage;
import PageObjects.confirmationPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class stepDefination extends BaseTest {
	
	public LandingPage landingPage;
	public ProductCatalogue productCatalogue;
	public cartPage cartPage1;
	public checkOutPage checkOutPage1;
	public confirmationPage confirmationPage1;
	String productName = "ADIDAS ORIGINAL";
	public WebDriver driver;
	
	@Given("I landed on Ecommerce Page")
	public void i_landed_on_ecommerce_page() throws IOException {
		driver=launchURL();;
	}
	@Given("Logged in with username {string} and password {string}")
	public void logged_in_with_username_and_password(String userName, String password) {
		
		 landingPage=new LandingPage(driver);
		landingPage.loginApplication(userName, password);
	}
	@When("I add product {string} to Cart")
	public void i_add_product_to_cart(String string) throws InterruptedException {
		productCatalogue = new ProductCatalogue(driver);
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.AddtoCart(productName);
		productCatalogue.goToCart();
	}
	@When("Checkout {string} and submit the order")
	public void checkout_and_submit_the_order(String productName) {
		cartPage cart = new cartPage(driver);
		cart.MatchProductsfromCart(productName);
		cart.clickCheckOutButton();
		checkOutPage checkOutPage1 = new checkOutPage(driver);
		checkOutPage1.placeOrder("India");
	}
	@Then("{string} message is displayed on ConfirmationPage")
	public void message_is_displayed_on_confirmation_page(String string) throws InterruptedException {
		confirmationPage confirmationPage1 = new confirmationPage(driver);
		confirmationPage1.verifyConfirmationMessage("THANKYOU FOR THE ORDER.");
		Thread.sleep(3000);;
		driver.quit();
	}
	
	@Then("{string} message is displayed")
	public void message_is_displayed(String string) {
		
		  
    	Assert.assertEquals(string, landingPage.getErrorMessage());
    	driver.quit();

	}
	
	

}
