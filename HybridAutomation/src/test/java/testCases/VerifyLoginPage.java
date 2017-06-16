package testCases;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.HomePage;
import pages.LoginPage;

public class VerifyLoginPage {

	static WebDriver driver;

	@BeforeMethod
	public void setUP() {
		driver = BrowserFactory.getBrowser("chrome");

		driver.get("https://www.amazon.com/");

	}

	@AfterMethod
	public void tearDown() {
		BrowserFactory.closeBrowser(driver);
	}

	@Test
	public void testHomePage() throws Exception {

		HomePage home = PageFactory.initElements(driver, HomePage.class);

		String title = home.getApplicationTitle();

		Assert.assertTrue(title.contains("Amazon.com: Online Shopping for Electronics"));

		home.clickOnSignIn();

		LoginPage login = PageFactory.initElements(driver, LoginPage.class);

		login.loginApplication(DataProviderFactory.getExcel().getData("Login", 0, 0),
				DataProviderFactory.getExcel().getData("Login", 0, 1));
		login.verifyHeaderPresence();
	}

}
