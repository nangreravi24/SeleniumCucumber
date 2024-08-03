package Runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "/Users/ravinangare/eclipse-workspace/Utkarshshaa_ws_24/Selenium_BDD/src/test/resources/Features/Login.feature",
		glue = {"stepDefinition"})
public class TestRunner {

}
