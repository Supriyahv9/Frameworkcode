package Module;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import CommonUtils.BaseClass;
import CommonUtils.ExcelUtils;
import CommonUtils.Listenerimplementation;
import CommonUtils.PropertyFileUtils;
import CommonUtils.WebDriverUtils;

@Listeners(Listenerimplementation.class)
public class CreateLeadTest extends BaseClass {

	

		PropertyFileUtils putils = new  PropertyFileUtils();
		ExcelUtils	eutils = new ExcelUtils();
		WebDriverUtils wutils = new WebDriverUtils();
		
		@Test
		public void CreateLead() throws IOException, InterruptedException {
		
		
		
		//To read data from Excel
		String FIRSTNAME = eutils.getdatafromExcel("Lead", 0, 1);
		String LASTNAME = eutils.getdatafromExcel("Lead", 1, 1);
		String COMPANYNAME = eutils.getdatafromExcel("Lead", 2, 1);
		String GROUP = eutils.getdatafromExcel("Lead", 3, 1);
		
		
					
				//Step7:Click on Leads
				driver.findElement(By.xpath("//a[text()='Leads']")).click();
				
			//Step8:Click on +(Create Leads..) icon
				driver.findElement(By.cssSelector("img[alt='Create Lead...']")).click();
				
			
				
			//Step9:Enter the First name
				driver.findElement(By.name("firstname")).sendKeys(FIRSTNAME);
				
				Assert.assertEquals("Pune", "Deccan");
				
			//Step10:Enter the Last name
				driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
				
				//Step11:Enter the Company name
				driver.findElement(By.name("company")).sendKeys(COMPANYNAME);
				
			//Step12:Click on Group radio button
				driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
		
		//Step13:Select Support Group in groupdropdown
			WebElement Groupdropdown = driver.findElement(By.name("assigned_group_id"));	
			wutils.handledropdown(Groupdropdown, GROUP);	
			
			//Step14:Click on Save btn
			driver.findElement(By.name("button")).click();	
			
			Thread.sleep(4000);
		
		
		
		
		
		
		
	}

}
