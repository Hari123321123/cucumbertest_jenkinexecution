package runner;




import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



//@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"C:\\Users\\Admin\\eclipse-workspace\\Test_BDD2\\src\\test\\resources\\features\\Login.feature"},
		glue = {"stepdefinitions", "hooks"},
		tags="@test",
		plugin = {"pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				
				"timeline:target/"

				
		}
		
		)




public class testNGRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = false)
   
    public Object[][] scenarios() {
        return super.scenarios();
       
        
        
    }

}
