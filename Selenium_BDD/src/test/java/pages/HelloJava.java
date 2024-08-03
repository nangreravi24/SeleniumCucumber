package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloJava {
	public static WebDriver driver;
	public static void main(String[] args) {
		System.out.println("Hello Java");
		driver = new ChromeDriver();
		driver.get("https://utkarshaaacademy.com");
	}

}
