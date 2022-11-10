package crm.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import crm.utility.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\cepha\\eclipse-workspace\\FreeCRM"
					+ "\\src\\main\\java\\crm\\config\\config.properties");
			prop.load(ip);
			
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}else if(browserName.equals("edge")) {
			System.setProperty("webdriver.msedge.driver", "C:\\Driver\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
	
	
	
}