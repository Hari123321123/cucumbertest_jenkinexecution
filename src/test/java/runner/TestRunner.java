package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\Admin\\git\\localrepo\\BDD\\src\\test\\resources\\features",
				 glue={"stepdefinitions","hooks"},
				 publish=true,
				 plugin={"pretty","html:target/CucumberReports/CucumberReport.html"},
				 tags= "@exe")
public class TestRunner {
	
	

}
