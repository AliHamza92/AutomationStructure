package base;

import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {

	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static FileReader fr;
	
	@BeforeTest
	public void setup() throws IOException {
		if (driver==null) {
			
			FileReader fr = new FileReader ("C:\\Users\\hamza\\git\\repository\\FrontEnd\\src\\test\\resources\\configfiles\\config.properties");
			prop.load(fr);
		}
		if(prop.getProperty("browser").equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			//driver.get("https://www.google.com/");
			driver.get(prop.getProperty("url"));
		}
		else if(prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			//driver.get("https://www.google.com/");
			driver.get(prop.getProperty("url"));
		}
		else if(prop.getProperty("browser").equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.get(prop.getProperty("url"));
		}
		
	}
	
	public void tearDown() {
	
		driver.close();
		System.out.println("TearDown Successfull");
 
	}
		
		
		
		
}
