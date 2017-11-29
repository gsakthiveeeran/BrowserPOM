package commonUtils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import io.appium.java_client.android.AndroidDriver;

public class TestCaseUtil {

	ReadData data;
	
	public static RemoteWebDriver driver;
	
	@BeforeMethod
	public void driverInitialize() throws MalformedURLException
	{	
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "7.1");
		capabilities.setCapability("deviceName", "device");
		capabilities.setCapability("udid", "96d6bc4a");
		capabilities.setCapability("appPackage", "com.mindvalley.mva");
		capabilities.setCapability("appActivity", "com.mindvalley.loginmodule.ui.OnboardingActivity");
		
		driver =new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		
	}
	
	@AfterMethod
	public void closeDriver()
	{
		driver.quit();
	}

	@DataProvider(name = "CorrectLoginDetail")
	public Object[][] correctLoginData() {
		try {
			data = new ReadData("CorrectData.properties");
			Map<String, String> correctData = data.readData();

			Object[][] userNamePassword = new Object[correctData.size()][2];

			int i = 0;

			for (Entry<String, String> s : correctData.entrySet()) {
				userNamePassword[i][0] = s.getKey();
				userNamePassword[i][1] = s.getValue();

				i++;
			}

			return userNamePassword;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@DataProvider(name = "WrongLoginDetail")
	public Object[][] wrongLoginData() {
		try {
			data = new ReadData("WrongData.properties");
			Map<String, String> correctData = data.readData();

			Object[][] userNamePassword = new Object[correctData.size()][2];

			int i = 0;

			for (Entry<String, String> s : correctData.entrySet()) {
				userNamePassword[i][0] = s.getKey();
				userNamePassword[i][1] = s.getValue();

				i++;
			}

			return userNamePassword;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
