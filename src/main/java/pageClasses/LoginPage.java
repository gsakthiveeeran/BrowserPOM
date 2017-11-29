package pageClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	RemoteWebDriver driver;
	
	@FindBy(id="user_email")
	WebElement emailId;
	
	
	@FindBy(id="user_password")
	WebElement password;
	
	@FindBy(xpath="//*[@id='new_user']/input[3]")
	WebElement Login;
	
	@FindBy(xpath="//*[@id='new_user']/div[3]/a")
	WebElement forgetPassword;
	
	@FindBy(xpath="//*[contains(text(),'Invalid email or password')]")
	WebElement inCorrectPasswordMessage;

	
	
	
	public LoginPage(RemoteWebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterEmailId(String email)
	{
		emailId.sendKeys(email);
	}
	
	public void enterPassword(String email)
	{
		password.click();
		password.sendKeys(email);
	}
	
	public void clickLoginButton()
	{
		Login.click();
	}
	
	public void clickForgetPasswordButton()
	{
		forgetPassword.click();
	}

	public Boolean isErrorMessageThrown() {
		
		if(inCorrectPasswordMessage.isDisplayed())
			return true;
		else
			return false;
	
	}

}
