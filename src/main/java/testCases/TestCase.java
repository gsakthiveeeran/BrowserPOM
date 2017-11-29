package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import activityClasses.ForgotPasswordActivityScreen;
import activityClasses.HomeActivityScreen;
import activityClasses.LoginActivityScreen;
import activityClasses.OnBoardActivityScreen;
import commonUtils.TestCaseUtil;
import io.appium.java_client.android.AndroidDriver;


public class TestCase extends TestCaseUtil{
	
@Test(dataProvider="CorrectLoginDetail")
public void successfulLogin(String username, String password) throws InterruptedException
{
	Boolean result = false;
	OnBoardActivityScreen onboardScreen;
	LoginActivityScreen login;
	HomeActivityScreen home;
	
	onboardScreen = new OnBoardActivityScreen(driver);
	onboardScreen.clickLoginButton();
	
	 if (((AndroidDriver) driver).currentActivity()
             .equals("com.mindvalley.loginmodule.ui.LoginActivity"))
	 {
		 login = new LoginActivityScreen(driver);
		 login.enterEmailId(username);
		 login.enterPassword(password);
		 login.clickLoginButton();
		 
		 home = new HomeActivityScreen(driver);
		 result = home.isLoginSuccessfull();
	 }
	 else
		 result = false;
	 
	 Assert.assertTrue(result, "Login Successfull");
	


}

@Test(dataProvider="WrongLoginDetail")
public void unsuccessfulLogin(String username, String password)
{

	Boolean result = false;
	OnBoardActivityScreen onboardScreen;
	LoginActivityScreen login;
	HomeActivityScreen home;
	
	onboardScreen = new OnBoardActivityScreen(driver);
	onboardScreen.clickLoginButton();
	
	 if (((AndroidDriver) driver).currentActivity()
             .equals("com.mindvalley.loginmodule.ui.LoginActivity"))
	 {
		 login = new LoginActivityScreen(driver);
		 login.enterEmailId(username);
		 login.enterPassword(password);
		 login.clickLoginButton();
		 
		 if (((AndroidDriver) driver).currentActivity()
	             .equals("com.mindvalley.loginmodule.ui.LoginActivity") && !((AndroidDriver) driver).currentActivity()
	             .equals("com.mindvalley.mva.ui.home.HomeActivity"))
			 result = true;
		 
	 }
	 else
		 result = false;
	 
	 Assert.assertTrue(result, "Login Successfull");
}

@Test
public void forgetPasswordTest() throws InterruptedException
{
	Boolean result=false;
	String email = "testEmail@gmail.com";
	OnBoardActivityScreen onboardScreen;
	LoginActivityScreen login;
	ForgotPasswordActivityScreen forgotPasswordScreen;
	
	onboardScreen = new OnBoardActivityScreen(driver);
	onboardScreen.clickLoginButton();
	
	 if (((AndroidDriver) driver).currentActivity()
             .equals("com.mindvalley.loginmodule.ui.LoginActivity"))
	 {
		 login = new LoginActivityScreen(driver);
		 login.clickForgetPasswordButton();
		 
		 forgotPasswordScreen =  new ForgotPasswordActivityScreen(driver);
		 if(forgotPasswordScreen.isPasswordResetScreenDisplayed())
		 {
			 forgotPasswordScreen.enterEmailId(email);
			 forgotPasswordScreen.sendEmailButton();
		 }
		 else
			 result = false;
	 }
	 else
		 result = false;
	 
	 Assert.assertTrue(result, "Login Successfull");
	
	
	
	
	
}

}
