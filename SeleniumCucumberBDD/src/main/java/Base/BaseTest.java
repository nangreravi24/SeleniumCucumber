package Base;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
	  public WebDriver driver;
	    public final static int TIMEOUT = 10;
	  
	    public WebDriver WebDriverManager ()  {
	  
	     
	        if (driver == null) {
	            driver = new ChromeDriver();
	            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
	            driver.manage().window().maximize();
	            driver.get("https://opensource-demo.orangehrmlive.com/");
	  
	        }
	        return driver;
	    }
}
