package PageDetails;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.StandardCopyOption;
import java.security.PublicKey;
import java.sql.Driver;
import java.time.Duration;
import java.util.Set;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.reporters.Files;

public class Login1 {
	WebDriver driver;
	By Register=By.xpath("//*[@id=\"gh-ug-flex\"]/a");
	By Personal_account=By.id("personalaccount-radio");
	By firstname=By.id("firstname");
	By lastname=By.id("lastname");
	By Email=By.id("Email");
	By password=By.id("password");
	By reg=By.name("EMAIL_REG_FORM_SUBMIT");
	By Login_ac=By.xpath("//*[@id=\"gh-ug\"]/a");
	By username1=By.id("userid");
	By user_btn=By.id("signin-continue-btn");
	By password_login=By.id("pass");
	By pass_btn=By.id("sgnBt");
	By searchbar=By.id("gh-ac");
	By searchicon=By.id("gh-btn");
	By selectitem=By.xpath("//*[@id=\"item1abe8c4ff1\"]/div/div[2]/a/div");
	By addtocart=By.xpath("//*[@id=\"mainContent\"]/div/div[8]/ul/li[2]/div/a");
	By mouse_wait=By.xpath("//*[@id=\"vl-flyout-nav\"]/ul/li[3]/a");
	By wait=By.xpath("//*[@id=\"vl-flyout-nav\"]/ul/li[3]/div[2]/div[1]/nav[2]/ul/li[1]/a");
	

	public Login1(WebDriver driver)
	{
		this.driver=driver;
	}
	//REGISTER
	public void Signin1() {
		driver.findElement(Register).click();
		driver.findElement(Personal_account).click();
		driver.findElement(firstname).sendKeys("rithuuu");
		driver.findElement(lastname).sendKeys("ks");

		driver.findElement(Email).sendKeys("rithuarun11@gmail.com");
		driver.findElement(password).sendKeys("Kashinath11@");
		driver.findElement(reg).click();
	       driver.navigate().to("https://www.ebay.com/");


	}
	
	//LOGIN
	public void Login() {
		driver.findElement(Login_ac).click();
		driver.findElement(username1).sendKeys("rithuarun11@gmail.com");
		driver.findElement(user_btn).click();
		driver.findElement(password_login).sendKeys("Kashinath11@");
		driver.findElement(pass_btn).click();
	       driver.navigate().to("https://www.ebay.com/");


	}
	//SEARCH and ADD TO CART(WINDOW HANDLING AND SCROLLING)
	public void search1() {
		driver.findElement(searchbar).sendKeys("harry potter book");
		driver.findElement(searchicon).click();
        String originalWindow = driver.getWindowHandle();
		driver.findElement(selectitem).click();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                JavascriptExecutor js=(JavascriptExecutor)driver;
				js.executeScript("window.scrollBy(0,250)", "");
				driver.findElement(addtocart).click();
			       driver.navigate().to("https://www.ebay.com/");


            }
        }
		
	}
	//MOUSE WAIT
	public void Mouse_wait() {
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement mouse=driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/ul/li[3]/a"));
		Actions act=new Actions(driver);
		act.moveToElement(mouse).perform();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"mainContent\"]/div[1]/ul/li[3]/div[2]/div[1]/nav[1]/ul/li[1]/a"))).click();
	       driver.navigate().to("https://www.ebay.com/");

	}

	//SCREENSHOT
	public void screenshot() throws IOException {
		WebElement scrnsht= driver.findElement(By.xpath("/html/body"));
		File src=scrnsht.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("G:\\abcde.png"));		
	       driver.navigate().to("https://www.ebay.com/");

	}
	//CONTENT VERIFY
	public void Content_Verify() {
		String content=driver.getPageSource();
		if(content.contains("ebay")) {System.out.println("Passed");}else {System.out.println("Failed");
	       driver.navigate().to("https://www.ebay.com/");
}
		}
	//DATA DRIVEN
	/*public void datadriven() throws IOException {
		File f=new File("G:\\user1.xlsx");
		FileInputStream fi=new FileInputStream(f);
		XSSFWorkbook wb=new XSSFWorkbook(fi);
		XSSFSheet sh=wb.getSheet("Sheet1");
		System.out.println(sh.getLastRowNum());

		for(int i=1;i<=sh.getLastRowNum();i++)
		{	
			String username=sh.getRow(i).getCell(0).getStringCellValue();
			System.out.println("username :"+username);
			String passwrd=sh.getRow(i).getCell(1).getStringCellValue();
			System.out.println("passwrd : "+passwrd);
			driver.findElement(username1).clear();
			driver.findElement(username1).sendKeys(username);
			driver.findElement(password_login).clear();
			driver.findElement(password_login).sendKeys(passwrd);
			driver.findElement(pass_btn).click();
				}		
	}*/
	
			}

	







