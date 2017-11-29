package pageClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasswordResetPage {
	
	RemoteWebDriver driver;
	
	@FindBy(id="user_email")
	WebElement emailId;
	
	
	@FindBy(className="btn--login")
	WebElement sendButtonToResetPassword;
	

	
	
	
	public PasswordResetPage(RemoteWebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterEmailId(String email)
	{
		emailId.sendKeys(email);
	}
	
	public void clickPasswordResetButton()
	{
		sendButtonToResetPassword.click();
		
	}


}
