package activityClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class OnBoardActivityScreen {
	
	RemoteWebDriver driver;
	
	@AndroidFindBy(id="com.mindvalley.mva:id/mindvalley_login_button")
	WebElement loginButton;

	
	public OnBoardActivityScreen(RemoteWebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	public void clickLoginButton()
	{
		loginButton.click();
	}


}
