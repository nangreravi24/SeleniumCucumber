package pages;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;


public class NewTest {
@Test
public void LauchChrome() {
	WebDriver driver = new ChromeDriver();
	driver.get("https://utkarshaaacademy.com");
	String title = driver.getTitle();
	String title1 = "Software Testing";
	Assert.assertEquals(title1, title);
}
}
