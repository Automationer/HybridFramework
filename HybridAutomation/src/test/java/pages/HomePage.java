package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver Idriver) {

		this.driver = Idriver;
	}

	@FindBy(xpath = ".//*[@id='nav-link-accountList']")
	WebElement signInLink;

	public void clickOnSignIn() throws Exception {
		signInLink.click();
		Thread.sleep(1000);
	}

	public String getApplicationTitle() {
		return driver.getTitle();
	}

}
