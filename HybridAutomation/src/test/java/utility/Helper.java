package utility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {


	public static String captureScreenShot(WebDriver driver, String screenshotName)
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		File src = ts.getScreenshotAs(OutputType.FILE);
		
		String destination = "C:/expert2017/workspaceMaven/HybridAutomation/Screenshots/" + screenshotName + System.currentTimeMillis() + ".png";
		
		try {
			FileUtils.copyFile(src, new File(destination));
		} catch (Exception e) {
			System.out.println("Failed to capture screenshot" + e.getMessage());
		}
		
		return destination;
	}

}
