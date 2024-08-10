package StepDefinition;

import org.openqa.selenium.WebElement;

import Base.BaseTest;
import Pages.PageObjectManager;

public class TestSetUp {
	public WebElement errorMessage;
    public WebElement homePageUserName;
    public PageObjectManager pageObjectManager;
    public BaseTest baseTest;
  
    public TestSetUp()  {
  
        baseTest = new BaseTest();
        pageObjectManager = new PageObjectManager(baseTest.WebDriverManager());
  
    }
}
