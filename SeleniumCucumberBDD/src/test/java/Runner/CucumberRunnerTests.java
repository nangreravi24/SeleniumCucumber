package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(tags = "", features = "/Users/ravinangare/eclipse-workspace/Utkarshshaa_ws_24/SeleniumCucumberBDD/src/main/resources/feature", glue = "StepDefinition",
plugin = "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:")
 

public class CucumberRunnerTests {

}
