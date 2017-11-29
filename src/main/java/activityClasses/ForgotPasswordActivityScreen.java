package activityClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ForgotPasswordActivityScreen {
	
	RemoteWebDriver driver;
	
	@AndroidFindBy(id="com.mindvalley.mva:id/login_edittext_email")
	WebElement emailId;
	
	@AndroidFindBy(id="com.mindvalley.mva:id/send_email_button")
	WebElement sendEmail;
	
	public ForgotPasswordActivityScreen(RemoteWebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public boolean isPasswordResetScreenDisplayed() {
		if (((AndroidDriver) driver).currentActivity().equals("com.mindvalley.loginmodule.ui.ForgotPasswordActivity"))
			return true;
		else
			return false;
	}
	
	public void enterEmailId(String email) {
		emailId.sendKeys(email);
	}
	
	public void sendEmailButton() {
		sendEmail.click();
	}

	
}
