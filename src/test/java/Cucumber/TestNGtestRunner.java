package Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src\\test\\java\\Cucumber", glue = "AutomationFramework.StepDefination", monochrome = true, plugin = {
		"html:target/cucumber.html" })
public class TestNGtestRunner extends AbstractTestNGCucumberTests {

}
