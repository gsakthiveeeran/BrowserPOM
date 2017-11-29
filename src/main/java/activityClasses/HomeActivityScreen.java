package activityClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomeActivityScreen {

	RemoteWebDriver driver;

	@AndroidFindBy(id = "com.mindvalley.mva:id/my_lib_tab_icon")
	WebElement libraryTabIcon;

	public HomeActivityScreen(RemoteWebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public boolean isLoginSuccessfull() {
		if (((AndroidDriver) driver).currentActivity().equals("com.mindvalley.mva.ui.home.HomeActivity"))
			return true;
		else
			return false;
	}
}
