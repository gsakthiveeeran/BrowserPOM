package pageClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	RemoteWebDriver driver;
	
	@FindBy(className="btn-dashboard")
	WebElement buttonDashboard;
	

	public HomePage(RemoteWebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean isLoginSuccessfull()
	{
		if(buttonDashboard.isDisplayed())
			return true;
		else
			return false;
		
	}
	


}
