package pages;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	@FindBy(id = "user-name")
	WebElement txttitle;

	@FindBy(id = "user-name")
	WebElement txtusername;

	@FindBy(id = "password")
	WebElement txtpassword;

	@FindBy(id = "login-button")
	WebElement btnlogin;

	public LoginPage(WebDriver driver) throws IOException {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public String getTitleValidate() {
		String title = driver.getTitle();
		assertEquals("Swag Labs", title);
		return title;
	}

	public void preencherUsername(String username) {
		txtusername.sendKeys(username);
	}

	public void preencherPassword(String password) {
		txtpassword.sendKeys(password);
	}

	public void clickbtnlogin() {
		btnlogin.click();
	}

	public void preencherLogin(String username, String password) throws IOException {

		getTitleValidate();
		preencherUsername(username);
		preencherPassword(password);
		clickbtnlogin();

	}
}
