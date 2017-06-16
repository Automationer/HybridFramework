package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;

	}

	@FindBy(css = "#ap_email")
	WebElement username;

	@FindBy(css = "#ap_password")
	WebElement password;

	@FindBy(css = "#signInSubmit")
	WebElement signUpBtn;

	By myName = By.xpath("//p[@class='hud-profilecard-name']");

	public void loginApplication(String user, String pass) {
		username.sendKeys(user);
		password.sendKeys(pass);
		signUpBtn.click();
	}

	public void verifyHeaderPresence() {
		WebDriverWait wait = new WebDriverWait(driver, 20);

		WebElement elem = wait.until(ExpectedConditions.presenceOfElementLocated(myName));

		Assert.assertNotNull(elem);
	}

}
