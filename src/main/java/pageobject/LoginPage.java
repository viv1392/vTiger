package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractP.Utilities;

public class LoginPage extends Utilities {
	WebDriver dvr;
	HomePage pge;

	public LoginPage(WebDriver dvr) {
		super(dvr);
		this.dvr = dvr;
		PageFactory.initElements(dvr, this);
	}

	@FindBy(name = "user_name")
	WebElement userName;
	@FindBy(name = "user_password")
	WebElement userPassword;
	@FindBy(name = "Login")
	WebElement signIn;

	public HomePage login(String name,String password) {
		userName.sendKeys(name);
		userPassword.sendKeys(password);
		signIn.click();
		pge = new HomePage(dvr);
		return pge;
	}

}
