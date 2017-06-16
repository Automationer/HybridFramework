package testCases;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.HomePage;
import pages.LoginPage;
import utility.Helper;

public class VerifyLoginPageWithReport1 {

	static WebDriver driver;
	ExtentReports report;
	ExtentTest logger;

	@BeforeMethod
	public void setUP() {

		report = new ExtentReports("./Reports/LoginPageReport.html", true);

		logger = report.startTest("Verify test login");

		driver = BrowserFactory.getBrowser("chrome");

		driver.get("https://www.amazon.com/");

		logger.log(LogStatus.INFO, "Application is up and running");
	}

	@Test
	public void testHomePage() throws Exception {

		HomePage home = PageFactory.initElements(driver, HomePage.class);

		String title = home.getApplicationTitle();

		Assert.assertTrue(title.contains("Amazon.com: Online Shopping for Electronics"));

		logger.log(LogStatus.PASS, "HomePage loaded succeefully and verified");

		home.clickOnSignIn();

		logger.log(LogStatus.INFO, "clicked On SignIn");

		LoginPage login = PageFactory.initElements(driver, LoginPage.class);

		login.loginApplication(DataProviderFactory.getExcel().getData("Login", 0, 0),
				DataProviderFactory.getExcel().getData("Login", 0, 1));

		logger.log(LogStatus.INFO, "Loginned to the application");

		login.verifyHeaderPresence();

		logger.log(LogStatus.INFO, logger.addScreenCapture(Helper.captureScreenShot(driver, "validation2")));

		logger.log(LogStatus.PASS, "Customer name present");
	}

	@AfterMethod
	public void tearDown(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {
			String path = Helper.captureScreenShot(driver, result.getName());
			logger.log(LogStatus.FAIL, logger.addScreenCapture(path));
		}

		BrowserFactory.closeBrowser(driver);
		report.endTest(logger);
		report.flush();
	}
}
