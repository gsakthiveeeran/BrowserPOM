package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import commonUtils.TestCaseUtil;
import pageClasses.HomePage;
import pageClasses.LoginPage;
import pageClasses.PasswordResetPage;

public class TestCase extends TestCaseUtil{
	
@Test(dataProvider="CorrectLoginDetail")
public void successfulLogin(String username, String password) throws InterruptedException
{
	LoginPage login;
	HomePage home;
	Boolean result = true;
	
	driver.get("https://auth.mindvalley.com/");
	
	login = new LoginPage(driver);
	login.enterEmailId(username);
	login.enterPassword(password);
	login.clickLoginButton();
	
	home = new HomePage(driver);
	result = home.isLoginSuccessfull();
	
	Assert.assertTrue(result, "Login Successfull");
	


}

@Test(dataProvider="WrongLoginDetail")
public void unsuccessfulLogin(String username, String password)
{
	LoginPage login;
	HomePage home;
	Boolean result = true;
	
	driver.get("https://auth.mindvalley.com/");
	
	login = new LoginPage(driver);
	login.enterEmailId(username);
	login.enterPassword(password);
	login.clickLoginButton();
	result = login.isErrorMessageThrown();

	Assert.assertTrue(result, "Error Message Thrown Correctly for inCorrect Login Details");
}

@Test
public void forgetPasswordTest() throws InterruptedException
{
	String emailId  = "forgorPasswordEmailId@gmail.com";
	LoginPage login;
	PasswordResetPage passwordReset;
	Boolean result = true;
	
	driver.get("https://auth.mindvalley.com/");
	
	login = new LoginPage(driver);
	login.clickForgetPasswordButton();
	
	passwordReset = new PasswordResetPage(driver);
	passwordReset.enterEmailId(emailId);
	Thread.sleep(5000);
	passwordReset.clickPasswordResetButton();
	
	
	
	
}

}
