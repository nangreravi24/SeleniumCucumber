package stepDefinition;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class teststeps {
	public static WebDriver driver;
	public String url = "http://www.flipkart.com";
	public String parent;
	public String child_window;
	@Before(order=1)
    public void beforeScenario(){
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
//		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);
	    parent=driver.getWindowHandle();
        System.out.println("This will run before the every Scenario");
    } 
	@Before(order=0)
    public void beforeScenarioStart(){
        System.out.println("-----------------Start of Scenario-----------------");
    } 
	@After(order=0)
    public void afterScenarioFinish(){
        System.out.println("-----------------End of Scenario-----------------");
    } 
	@After(order=1)
    public void afterScenario(){
		driver.quit();
        System.out.println("This will run after the every Scenario");
    } 
	@Given("I navigate to the login page")
	public void i_navigate_to_the_login_page() {
			System.out.println("user navigate to login page successfully");
	}
	@When("I submit username and password")
	public void i_submit_username_and_password() {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enter_credentials();
		loginpage.clickOn_LoginBtn(driver);
	}
	@Then("I should be logged in")
	public void i_should_be_logged_in() {
		 	String username = "Ravi";
		    String actualusername = driver.findElement(By.xpath("//div[@class='_1psGvi _3BvnxG']//div//div[contains(text(),'Ravi')]")).getText();
		    Assert.assertEquals(username, actualusername);
	}
	@Given("User search for Lenovo Laptop")
	public void user_search_for_lenovo_laptop() {
		 driver.findElement(By.xpath("//input[@title='Search for products, brands and more']")).sendKeys("hp laptop");
		 driver.findElement(By.xpath("//button[@class='L0Z3Pu']")).click();
		 driver.findElement(By.xpath("//a[contains(text(),'HP Pavilion Gaming Ryzen 5 Quad Core 3550H - (8 GB/1 TB')]")).click();	 
	}
	@When("Add the first laptop that appears in the search result to the basket")
	public void add_the_first_laptop_that_appears_in_the_search_result_to_the_basket() {
		Set<String>s=driver.getWindowHandles();
		  
		  Iterator<String> I1= s.iterator();

		  while(I1.hasNext())
		  {

		  child_window=I1.next();
		  if(!parent.equals(child_window))
		  {
		  driver.switchTo().window(child_window);

		  System.out.println(driver.switchTo().window(child_window).getTitle());
		  WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		  WebElement AddtoCart = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww'][text()='ADD TO CART']"));
		  Actions action=new Actions(driver);
		  action.moveToElement(AddtoCart).build().perform();
		  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww'][text()='ADD TO CART']"))).click();
		  }
		  }
		  System.out.println("Hp Laptop successfully add into cart");
	}
	@Then("User basket should display with added item")
	public void user_basket_should_display_with_added_item() {
	   
	}

}
