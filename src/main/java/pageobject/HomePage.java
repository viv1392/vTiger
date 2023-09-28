package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractP.Utilities;

public class HomePage extends Utilities {
	public WebDriver dvr;

	public HomePage(WebDriver dvr) {
		super(dvr);
		this.dvr = dvr;
		PageFactory.initElements(dvr, this);
	}

	@FindBy(xpath = "//a[text()='Sign Out']")
	WebElement signOut;

	public void signout() {
		signOut.click();
	}

}
