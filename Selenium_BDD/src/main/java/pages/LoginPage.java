package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	 public LoginPage(WebDriver driver) {
	     PageFactory.initElements(driver, this);
	 }
	 @FindBy(xpath = "//div[@class='VCR99n']//form//input[@type='text']") 
	 private WebElement username;
	 
	 @FindBy(xpath = "//div[@class='_36HLxm col col-3-5']//form//input[@type='password']") 
	 private WebElement password;
	 
	 @FindBy(xpath = "//span[text()='Login']") 
	 private WebElement LoginBtn;
	 
	 public void enter_username(String userName) {
		 username.sendKeys(userName);
		 }
	 public void enter_password(String passWord) {
		 password.sendKeys(passWord);
		 }
	 public void clickOn_LoginBtn(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", LoginBtn);
		 }
	 public void enter_credentials() {
		 enter_username("abc@gmail.com");
		 enter_password("P@ssw0rdRn");
		 }
}
