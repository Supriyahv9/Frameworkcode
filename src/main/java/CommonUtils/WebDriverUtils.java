package CommonUtils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtils {

public void maximizewindow(WebDriver driver) {
		
		driver.manage().window().maximize();
	}

public void WaitWebelementToLoad(WebDriver driver) {
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}

public void handledropdown(WebElement target,String text) {
	
	Select s = new Select(target);
	s.selectByVisibleText(text);
}

public void mousehover(WebDriver driver,WebElement target) {
	
	Actions a = new Actions(driver);
	a.moveToElement(target);
	a.perform();
}

public void Switch(WebDriver driver,String expectedurl) {
	
	Set<String> ids = driver.getWindowHandles();
	System.out.println(ids);
	
	for(String e : ids) {
		String actaulurl = driver.switchTo().window(e).getCurrentUrl();
	
		
		if(actaulurl.contains(expectedurl)) {
			break;
		}
	}
}
	public String  totakescreenshot(WebDriver driver,String Screenshotname) throws IOException {
		LocalDateTime ldt = LocalDateTime.now();
		String timestramp = ldt.toString().replace(':', '-');
		TakesScreenshot ts = (TakesScreenshot) driver;	
		File tempfile = ts.getScreenshotAs(OutputType.FILE);
		File destinationfile = new File("./screenshots/"+Screenshotname+".png");
		FileUtils.copyFile(tempfile, destinationfile);
		return destinationfile.getAbsolutePath();
	}
}
