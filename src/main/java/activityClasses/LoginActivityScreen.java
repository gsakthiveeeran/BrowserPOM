package activityClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginActivityScreen {

	RemoteWebDriver driver;

	@AndroidFindBy(id = "com.mindvalley.mva:id/login_edittext_email")
	WebElement emailId;

	@AndroidFindBy(id = "com.mindvalley.mva:id/login_edittext_password")
	WebElement password;

	@AndroidFindBy(id = "com.mindvalley.mva:id/login_btn_login")
	WebElement loginButton;

	@AndroidFindBy(id = "com.mindvalley.mva:id/login_text_reset")
	WebElement forgotPassword;

	public LoginActivityScreen(RemoteWebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void enterEmailId(String email) {
		emailId.sendKeys(email);
	}

	public void enterPassword(String email) {
		password.click();
		password.sendKeys(email);
	}

	public void clickLoginButton() {
		loginButton.click();
	}

	public void clickForgetPasswordButton() {
		forgotPassword.click();
	}

}

