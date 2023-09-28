package vtigerCRm;

import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import baseComponent.BaseTest;
import baseComponent.Retry;
import pageobject.HomePage;
import pageobject.LoginPage;

public class LoginFuctionalityTest extends BaseTest {
	LoginPage loginP;

	@Test(dataProvider = "userdata")             // with valid user and password
	public void loginTest(HashMap<String, String> input) {
		loginP = new LoginPage(dvr);
		HomePage hmP = loginP.login(input.get("name"), input.get("password"));
		hmP.signout();
	}

	@DataProvider(name = "userdata")
	public Object[][] dataUser() throws Throwable {
		List<HashMap<String, String>> data1 = data(
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\userdata.json");
		return new Object[][] { { data1.get(0) } };
	}
	
	
	
	@Test(dataProvider = "userdata1" ,retryAnalyzer=Retry.class)             // with invalid user and password
	public void invalidloginTest(HashMap<String, String> input) {
		loginP = new LoginPage(dvr);
		HomePage hmP = loginP.login(input.get("namee"), input.get("passwordd"));
		hmP.signout();
	}

	@DataProvider(name = "userdata1")
	public Object[][] dataUser1() throws Throwable {
		List<HashMap<String, String>> data1 = data(
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\userdata.json");
		return new Object[][] { { data1.get(0) } };

	}
}
