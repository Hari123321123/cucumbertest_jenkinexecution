package stepdefinitions;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class seleniumgrid {
	
	public String userName="haribhauchaudhar_eoAU1n";
	public String accesskey="nRxAGRrt236WFrJDcrvs";
	public String url= "https://"+userName+":"+accesskey+"@hub.browserstack.com/wd/hub";
	

	public void setup() throws MalformedURLException {
System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");  

DesiredCapabilities cp=new DesiredCapabilities();
cp.setBrowserName("chrome");
cp.setPlatform(Platform.WIN11);
cp.setVersion("120");
URL burl=new URL(url);
WebDriver driver = new RemoteWebDriver(burl,cp);
//WebDriver driver = new RemoteWebDriver(new URL("http://192.168.142.251:4444"),cp);
ExtentReports reports = new ExtentReports();
		  
File file=new File("C:\\Users\\Admin\\git\\selenium_ref\\Reports\\reports.html");

 ExtentSparkReporter reporter =new  ExtentSparkReporter(file);

 reports.attachReporter(reporter);
		 	//create an object of chrome driver
	driver.get("https://www.amazon.in/");
	driver.manage().window().maximize();
		
	driver.quit();
		
	}
}
