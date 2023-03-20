package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "Features", glue = "com.stepDef", dryRun = false, monochrome = true, plugin = {"pretty", 
"html:target//index.html"}, tags = "@Login and @positive")
public class TestRunner {

}
