package CommonUtils;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {

	public WebDriver driver;
	//only to take screenshot
		public static WebDriver sdriver;
	
	PropertyFileUtils putils = new  PropertyFileUtils();
	WebDriverUtils wutils = new WebDriverUtils();
	
	
	@BeforeSuite
	public void BS() {
		System.out.println("Connect to data base");
	}
	
	@BeforeClass
	public void BC() throws IOException {
	
		//To read data from property file
				String BROWSER = putils.getdatafromProprtyFile("browser");
				String URL = putils.getdatafromProprtyFile("url");
				
				//To Launch browser 	
				if(BROWSER.equalsIgnoreCase("Chrome")) {
				 driver = new ChromeDriver();
				}else if(BROWSER.equalsIgnoreCase("Edge")) {
				 driver = new EdgeDriver();
				}else {
				driver = new FirefoxDriver();	
				System.out.println("Default browser");
				}
				
				sdriver=driver;
				//Maximize window
				wutils.maximizewindow(driver);
				//To apply implicit wait
				wutils.WaitWebelementToLoad(driver);

				
				//Step5:Load the url
				driver.get(URL);		
	}
	
	@BeforeMethod
	public void BM() throws IOException {
		//To read data from property file
			String USERNAME = putils.getdatafromProprtyFile("username");
			String PASSWORD = putils.getdatafromProprtyFile("password");
	
			//Step6:Login to application
			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();	
	
	
	}
	
	@AfterMethod
	public void AM() throws InterruptedException {
		//Step15:Mouse hover on Administrator icon
		WebElement adminicon = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wutils.mousehover(driver, adminicon);
		
		Thread.sleep(2000);
		
		//Step16:Click on Signout 
	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

	}
	
	@AfterClass
	public void AC() {
		driver.quit();
	}
	
	@AfterSuite
	public void AS() {
		System.out.println("Disconnect from data base");
	}
}
