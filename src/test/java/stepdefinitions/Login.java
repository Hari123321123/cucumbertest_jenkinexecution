package stepdefinitions;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.io.Files;

import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;



import factory.DriverFactory;
import hooks.ExtentReportListener;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonUtils;
import utils.ConfigReader;
import utils.ElementUtils;

public class Login extends ExtentReportListener{
	
	 WebDriver driver;
	private LoginPage loginPage;
	private AccountPage accountPage;
	private CommonUtils commonUtils;
	private ElementUtils elementutils;
	@Given("User navigates to login page")
	public void user_navigates_to_login_page() throws IOException {
		
		// File file=new File("C:\\Users\\Admin\\eclipse-workspace\\Test_BDD2\\test output\\spark\\reports.html");
		// ExtentSparkReporter reporter =new  ExtentSparkReporter(file);
		//reports.attachReporter(reporter);
		extent=ExtentReportListener.setUp();

		driver = DriverFactory.getDriver();
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		loginPage = homePage.selectLoginOption();
		
		File screenshotsource = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  
		  File screenshotfile = new File("D:\\ssa.png" );
		  
		  Files.copy(screenshotsource, screenshotfile);
		  String path ="D://ssa.png";
		 extent.createTest("User navigates to login page","adding screenshot")
		  .addScreenCaptureFromPath(path,"homepage");
		  
		
		
		
	
	}
	
	@When("^User enters valid email address (.+) into email field$")
	public void User_enters_valid_email_address_into_email_field(String emailText) throws IOException {
		
		loginPage.enterEmailAddress(emailText);
		File screenshotsource = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  
		  File screenshotfile = new File("D://email.png" );
		  
		  Files.copy(screenshotsource, screenshotfile);
		  String path ="D://email.png";
		 extent.createTest("User enters valid email address (.+) into email field","adding screenshot")
		  .addScreenCaptureFromPath(path,"home");
		
	}
	
	@And("^User enters valid password (.+) into password field$")
	public void user_enters_valid_password_into_password_field(String passwordText) throws IOException {
		
	    
		loginPage.enterPassword(passwordText);
		File screenshotsource = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  
		  File screenshotfile = new File("D://pass.png" );
		  
		  Files.copy(screenshotsource, screenshotfile);
		  String path ="D://pass.png";
		 extent.createTest("User enters valid password (.+) into password field","adding screenshot")
		  .addScreenCaptureFromPath(path,"pass");
	}

	@And("User clicks on Login button")
	public void user_clicks_on_login_button() throws IOException {
	    
		accountPage = loginPage.clickOnLoginButton();
		File screenshotsource = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  
		  File screenshotfile = new File("D://sa.png" );
		  
		  Files.copy(screenshotsource, screenshotfile);
		  String path ="D://sa.png";
		 extent.createTest("User clicks on Login button","adding screenshot")
		  .addScreenCaptureFromPath(path,"home");
	}

	@Then("User should get successfully logged in")
	public void user_should_get_successfully_logged_in() throws IOException {
		
		Assert.assertTrue(accountPage.displayStatusOfEditYourAccountInformationOption());
	    
		File screenshotsource = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  
		  File screenshotfile = new File("D://l.png" );
		  
		  Files.copy(screenshotsource, screenshotfile);
		  String path ="D://l.png";
		 extent.createTest("User should get successfully logged in","adding screenshot")
		  .addScreenCaptureFromPath(path,"loginpage");
		 extent.flush();
	
	}

	@When("User enters invalid email address into email field")
	public void user_enters_invalid_email_address_into_email_field() throws IOException {
			    
		commonUtils = new CommonUtils();
		
		loginPage.enterEmailAddress(commonUtils.getEmailWithTimeStamp());
		
		
	
	}

	@When("User enters invalid password {string} into password field")
	public void user_enters_invalid_password_into_password_field(String invalidPasswordText) {
	    
		loginPage.enterPassword(invalidPasswordText);
		
	}

	@Then("User should get a proper warning message about credentials mismatch")
	public void user_should_get_a_proper_warning_message_about_credentials_mismatch() {
	  
		Assert.assertTrue(loginPage.getWarningMessageText().contains("Warning: No match for E-Mail Address and/or Password."));
		
		
	}

	@When("User dont enter email address into email field")
	public void user_dont_enter_email_address_into_email_field() {
		
		loginPage.enterEmailAddress("");
	    
	}

	@When("User dont enter password into password field")
	public void user_dont_enter_password_into_password_field() {
	    
		loginPage.enterPassword("");
		
	}
	

}
