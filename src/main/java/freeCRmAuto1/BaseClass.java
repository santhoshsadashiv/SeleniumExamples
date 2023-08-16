package freeCRmAuto1;


import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import Utils.ReadExcelFile;
import Utils.TakeScreenShot;
import io.github.bonigarcia.wdm.WebDriverManager;



public class BaseClass {
	public static WebDriver driver;
	public static String excelFileName ="";
	public static String browser,url,emailid,password, title, task ;
	ExtentReports extent;
	public ExtentTest  test;
	public static  String testName,testDescription,testAuthor;

	@BeforeSuite
	public void BeforeTest() {
		//set up physical path
		ExtentSparkReporter reporter = new ExtentSparkReporter("./ExtentReports/result.html");
		//reporter.setAppendExisting(true);
		//create object for extent reports
		extent = new ExtentReports();
		//attach the data with physical file
		extent.attachReporter(reporter);
		
		extent.setSystemInfo("Username: ", "Santhosh");
		extent.setSystemInfo("Environment: ", "Automation Testing");
		//Create Test cases and assign test details
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setAcceptInsecureCerts(true);



	}
	@DataProvider(name="fetch")
	public String[][] fetchData() throws IOException
	{
		String [] [] data = ReadExcelFile.ReadExcel(excelFileName);
		return data;
	}

	@BeforeClass
	public void testcaseDetails() {
		test = extent.createTest(testName, testDescription);
		test.assignAuthor(testAuthor);
		
	}

	
	


	
@Parameters({"browser","url"})
	@BeforeMethod
			public void setupBrowser(String browser,String url) {
			
			
			switch(browser) {
			case "chrome":
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--remote-allow-origins=*"); 
				options.addArguments("--disable-notifications");
				options.addArguments("--disable-notifications");
				WebDriverManager.chromedriver().setup();
				 driver = new ChromeDriver(options);
				 break;
			case "Edge":
				WebDriverManager.edgedriver().setup();
				 driver = new EdgeDriver();
				 break;
			case "Firefox":
				WebDriverManager.firefoxdriver().setup();
				 driver = new FirefoxDriver();
				 break;
			case "IE":
				WebDriverManager.iedriver().setup();
				 driver=new InternetExplorerDriver();
				 break;
			default:
				System.out.println("Not able to invoke browser");
				break;
			}
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.manage().window().maximize();
			
		}
	

	@AfterMethod
	public void Postconditions() {
		TakeScreenShot scr = new TakeScreenShot();
		scr.takeSnap();
		driver.close();

	}


	@AfterSuite
	public void AfterTest() {
		extent.flush();
	}

}
