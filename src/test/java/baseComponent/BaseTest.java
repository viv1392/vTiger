package baseComponent;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageobject.LoginPage;

public class BaseTest {
	public WebDriver dvr;
	public LoginPage loginP1;
	static Properties prop;
	static FileInputStream fis;

	public WebDriver dvrIntialitaion() throws Throwable {
		prop = new Properties();
		fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\Browser.properties");
		prop.load(fis);
		String browser = prop.getProperty("browser");
		
		
		if (browser.equalsIgnoreCase("ch")) {
			WebDriverManager.chromedriver().setup();
			dvr = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			// code for edge
		} else if (browser.equalsIgnoreCase("firefox")) {
			// code here
		}
		dvr.manage().window().maximize();
		dvr.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return dvr;
	}

	@BeforeMethod
	public LoginPage url() throws Throwable {
		prop = new Properties();
		fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\Browser.properties");
		prop.load(fis);
		String uRL = prop.getProperty("url");
		dvr = dvrIntialitaion();
		dvr.get(uRL);
		loginP1 = new LoginPage(dvr);
		return loginP1;
	}

	public List<HashMap<String, String>> data(String filepath) throws Throwable {
		String jasonfile = FileUtils.readFileToString(new File(filepath), StandardCharsets.UTF_8);
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jasonfile,
				new TypeReference<List<HashMap<String, String>>>() {

				});
		return data;
	}

	public String screenShot(String testCaseName, WebDriver dvr) throws Throwable {
		TakesScreenshot scr = (TakesScreenshot) (dvr);
		File source = scr.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
	}

	@AfterMethod
	public void tearDown() {
		dvr.quit();
	}

}
