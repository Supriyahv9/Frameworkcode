package Module;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import CommonUtils.BaseClass;
import CommonUtils.ExcelUtils;
import CommonUtils.JavaUtils;
import CommonUtils.PropertyFileUtils;
import CommonUtils.WebDriverUtils;

public class CreateOrganizationTest extends BaseClass {

	@Test
	public void Organization() throws IOException, InterruptedException {
	
	
		 
		
		PropertyFileUtils futils = new PropertyFileUtils();
		WebDriverUtils wutils = new WebDriverUtils();
		ExcelUtils eutils = new ExcelUtils();
		JavaUtils jutils = new JavaUtils();
		
		
		
		/*To read data from excel file*/
		String OrgName = eutils.getdatafromExcel("Organization", 0, 1);
		String Group = eutils.getdatafromExcel("Organization", 1, 1);
		String Industry = eutils.getdatafromExcel("Organization", 2, 1);
		
		
		
		//Click on Organization
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		//Click on Organization + image
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		//Enter accountname
		driver.findElement(By.name("accountname")).sendKeys(OrgName+jutils.getRandomnumber());
		////To click on group radio button
		driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
		Thread.sleep(2000);
		//Dropdown WebElement
		WebElement dropdown = driver.findElement(By.name("assigned_group_id"));
		//Handle dropdown by visible text
		wutils.handledropdown(dropdown, Group);
		
	
		
	
		//To click Save button	
		driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
		
		Thread.sleep(4000);

}
}
