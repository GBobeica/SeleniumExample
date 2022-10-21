package Tests;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.NavigationMenu;
import Utils.BaseTest;

public class DataProviderExample extends BaseTest {
	
	@DataProvider(name = "loginTestData") 
	public Object[][] loginTestData(){
		Object[][] data = new Object [4][3];
		//String[] textArray = new String[3]
		//textArray[0] = "text index 0"
		//textArray[1] = "text index 1"
		//int[] numberArray = new int[5]
		
		data[0][0] = "TestUser";
		data[0][1] = "12345@67890";
		data[0][2] = true;
		
		
		data[1][0] = "userGresit";
		data[1][1] = "parolaGresita";
		data[1][2] = false;
		
		data[2][0] = "test.test";
		data[2][1] = "test.test@123";
		data[2][2] = true;
		
		data[3][0] = "altUserGresit";
		data[3][1] = "altaParolaGresita";
		data[3][2] = false;
		
		
		return data;
	}
     @Test(dataProvider = "loginTestData") 
	 public void loginTest(String user, String pass, boolean success) {
    	 
    	 NavigationMenu menu = new NavigationMenu(driver);
    	 menu.navigateTo(menu.loginLink);
    	 LoginPage loginPage = new LoginPage(driver);
    	 loginPage.loginInApp(user, pass);
    	 
    	 if(success) {
    		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        	// wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.sucessLoginMessage));
    		 assertTrue(loginPage.checkMessageIsDisplayed(loginPage.sucessLoginMessage)); 
    	 
    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	 wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.logoutButton));
    	 
    	 loginPage.logoutFromApp();
		 
	 }else if(!success) {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	 wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.errorLoginMessage));
    	 
		 assertTrue(loginPage.checkMessageIsDisplayed(loginPage.errorLoginMessage));
		 loginPage.closeLoginPopup();
	 }
}
}
