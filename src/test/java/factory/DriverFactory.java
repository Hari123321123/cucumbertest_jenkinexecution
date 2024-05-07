package factory;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import utils.CommonUtils;

public class DriverFactory {
	
	static WebDriver driver = null;
	public static  String userName="haribhauchaudhar_eoAU1n";
	public static String accesskey="nRxAGRrt236WFrJDcrvs";
	public static String url= "https://"+userName+":"+accesskey+"@hub.browserstack.com/wd/hub";
	
	public static WebDriver initializeBrowser(String browserName) throws InterruptedException, MalformedURLException {
		
		
		
		
	/*	System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");  
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		DesiredCapabilities cp=new DesiredCapabilities();
		cp.setCapability(ChromeOptions.CAPABILITY, options);
        options.merge(cp);*/
		
		
		if(browserName.equals("chrome")) {
			
			//for browserstack
			
			System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");  

			DesiredCapabilities cp=new DesiredCapabilities();
			cp.setBrowserName("chrome");
			cp.setPlatform(Platform.MAC);
			cp.setVersion("120");
			URL burl=new URL(url);
			driver = new RemoteWebDriver(burl,cp);
			
			/*driver = new ChromeDriver(options);
			System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");  
			ChromeOptions op=new ChromeOptions();
			DesiredCapabilities cp1=new DesiredCapabilities();
			cp1.setBrowserName("chrome");
			cp1.setPlatform(Platform.WIN11);
			op.merge(cp1);
			 driver = new RemoteWebDriver(new URL("http://192.168.142.251:4444"),op);
			*/
			//driver = new ChromeDriver(options);
			
		}else if(browserName.equals("firefox")) {
			
			driver = new FirefoxDriver();
			
		}else if(browserName.equals("edge")) {
			
			driver = new EdgeDriver();
			
		}else if(browserName.equals("safari")) {
			
			driver = new SafariDriver();
			
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(CommonUtils.PAGE_LOAD_TIME));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(CommonUtils.IMPLICIT_WAIT_TIME));
		
		return driver;
	}
	
	public static WebDriver getDriver() {
		
		return driver;
		
	}

}
