package StepDefinition;

import org.junit.Assert;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.PageObjectManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageDefinitions {
	 TestSetUp setUp;
	    public PageObjectManager pageObjectManager;
	    public LoginPage loginPage;
	    public HomePage homePage;
	 
	 
	    public LoginPageDefinitions(TestSetUp setUp)  {
	        this.setUp = setUp;
	        this.loginPage = setUp.pageObjectManager.getLoginPage();
	        this.homePage= setUp.pageObjectManager.getHomePage();
	    }
	 
	    @Given("User is on Home page")
	    public void loginTest()  {
	        setUp.baseTest.WebDriverManager().get("https://opensource-demo.orangehrmlive.com/");
	 
	    }
	 
	    @When("User enters username as {string} and password as {string}")
	    public void goToHomePage(String userName, String passWord) {
	 
	        // login to application
	        loginPage.login(userName, passWord);
	 
	        // go the next page
	 
	    }
	 
	    @Then("User should be able to login successfully")
	    public void verifyLogin() {
	 
	        // Verify home page
	        Assert.assertTrue(homePage.getHomePageText().contains("Dashboard"));
	 
	    }
	 
	    @Then("User should be able to see error message {string}")
	    public void verifyErrorMessage(String expectedErrorMessage) {
	 
	        // Verify home page
	        Assert.assertEquals(loginPage.getErrorMessage(),expectedErrorMessage);
	 
	    }
}
