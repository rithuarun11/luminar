package TestDetails;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageDetails.Login1;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestDetails {
	WebDriver driver;
		@Test

	public void test() throws IOException {
			
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.ebay.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));		
		Login1 ob=new Login1(driver);
		//ob.datadriven();
		ob.Mouse_wait();
		ob.Content_Verify();
		
		ob.Signin1();
		 ob.Login();
		ob.search1();
		ob.screenshot();
		//ob.cross_browser();	
			}


@Test
public void testFirefox() {
    // Initialize WebDriver for Firefox
    WebDriverManager.firefoxdriver().setup();
    driver = new FirefoxDriver();
    driver.get("https://www.ebay.com/");
}
@Test
public void edgedriver() 
{                WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			    driver.get("https://www.ebay.com/");

}

}