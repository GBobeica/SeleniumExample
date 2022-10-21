package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.gson.internal.UnsafeAllocator;



public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver; 
	}
	
	//locatori
	public By usernameField = By.cssSelector("input[id='log']");
	public By passwordField = By.id("password");
	public By submitButton = By.className("submit_button");
	public By logoutButton = By.cssSelector("li[class='menu_user_logout']");
	public By sucessLoginMessage = By.cssSelector("div[class*='sc_infobox_style_success']");
	public By errorLoginMessage = By.cssSelector("div[class*='sc_infobox_style_error']");
	public By closePopUpButton = By.cssSelector("a[class='popup_close"); 
	
	
	
	//metode
	public void loginInApp(String user , String pass) {
		//Log.info("call method loginInApp");
		driver.findElement(usernameField).clear();
		driver.findElement(usernameField).sendKeys(user);
		//Log.info("send username " + user);
		driver.findElement(passwordField).clear();
		driver.findElement(passwordField).sendKeys(pass);
		//Log.info("send password "+ pass);
		driver.findElement(submitButton).click();
		//Log.info(" Clicked submit  button");
		
	
	}
	
	public void logoutFromApp() {
		driver.findElement(logoutButton).click();
	}
	
	public boolean checkMessageIsDisplayed(By locator) {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	 wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return driver.findElement(locator).isDisplayed();
		
	}
	public void closeLoginPopup() {
		driver.findElement(closePopUpButton).click();
		
	}
}
