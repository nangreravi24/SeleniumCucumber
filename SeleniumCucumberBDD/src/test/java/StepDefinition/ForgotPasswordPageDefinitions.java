package StepDefinition;

import org.junit.Assert;

import Pages.ForgotPasswordPage;
import Pages.LoginPage;
import Pages.PageObjectManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ForgotPasswordPageDefinitions {
	TestSetUp setUp;
    PageObjectManager pageObjectManager;
    public LoginPage loginPage;
    public  ForgotPasswordPage forgotPasswordPage;
 
    public ForgotPasswordPageDefinitions(TestSetUp setUp) {
        this.setUp = setUp;
        this.loginPage = setUp.pageObjectManager.getLoginPage();
        this.forgotPasswordPage = setUp.pageObjectManager.getForgotPasswordPage();
    }
 
    @When("User clicks on Forgot your password? link")
    public void forgotPasswordLink() {
 
        loginPage.clickOnForgotPasswordLink();
 
    }
 
    @Then("User should be able to navigate to Reset Password page")
    public void verifyForgotPasswordPage() {
 
        Assert.assertEquals(forgotPasswordPage.getForgotPageText(),"Reset Password");
 
    }
 
    @Then("User clicks on Cancel button to go back to Login Page")
    public void verifyCancelBtn() {
 
        forgotPasswordPage.clickOnCancelBtn();
        Assert.assertEquals(loginPage.getLoginPageTitle(),"Login");
 
    }
 
    @Then("User clicks on Reset Password button and provide username as {string}")
    public void verifyResetPasswordBtn(String username) {
 
        forgotPasswordPage.TypeOnUsernameTextBox(username);
        forgotPasswordPage.clickOnRestPasswordBtn();
 
    }
 
    @Then("Verify the message {string}")
    public void verifyMessage(String message) {
 
        //  ForgotPasswordPage forgotPasswordPage = setUp.pageObjectManager.getForgotPasswordPage();
        Assert.assertEquals(forgotPasswordPage.getRestMessage(),message);
 
    }
}
