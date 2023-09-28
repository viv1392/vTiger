package abstractP;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Utilities {
	public WebDriver dvr;
	public Utilities(WebDriver dvr) {
		this.dvr=dvr;
		PageFactory.initElements(dvr, this);
		
		
	}

}
