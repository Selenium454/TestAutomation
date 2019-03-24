package reports;

import java.io.File;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import genericFunctions.Constants_Global;
import webPages.HMSLoginPage;

public class AdvExtentReports {

	public static WebDriver driver = null;
	public ExtentHtmlReporter htmlReporter = null;
	public ExtentReports extent = null;
	public static ExtentTest logger = null;
	public static HMSLoginPage hmslogin = null;

	@BeforeSuite(alwaysRun = true)
	public void startReport() {

		htmlReporter = new ExtentHtmlReporter("./Report/extent.html");

		extent = new ExtentReports();

		extent.attachReporter(htmlReporter);

	}
//teSTING DONE
	@AfterSuite(alwaysRun = true)
	public void endReport() {

		extent.flush();
	}

	@BeforeMethod(alwaysRun = true)
	public void initPageObjects(Method name) {
		
		logger = extent.createTest(name.getName(),name.getDeclaringClass().getName());

		hmslogin = new HMSLoginPage();
	}

	@BeforeMethod(alwaysRun = true)
	@Parameters({"browser"})
	public void initApplication(String browserName) {

		getBrowser(browserName);
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public static void getScreen(String path) {
		try {
			
			File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(source, new File(path));
			
		} catch (Exception e) {
			
		}
	}
	
	@AfterMethod(alwaysRun = true)
	public static void verifyStatus(ITestResult result) {

		try {
			if (result.getStatus() == ITestResult.FAILURE) {

				// Timestamp time = new Timestamp(System.currentTimeMillis());
				logger.fail(MarkupHelper.createLabel(result.getName() + " Test Case Failed", ExtentColor.RED));
				
				
				logger.fail(result.getThrowable());
				
				
				getScreen("./Report/Screenshots/" + result.getName() + ".png");
				
				
				String screenlocation = "./Screenshots/" + result.getName() + ".png";

				logger.fail("Screen Shot Reference:  ",
						MediaEntityBuilder.createScreenCaptureFromPath(screenlocation).build());
			}
		} catch (Exception e) {
			logger.log(Status.FAIL, "Faile to due to below error");
			Assert.fail(e.getMessage());
		}
	}

	public void getBrowser(String name) {

		switch (name) {
		case "chrome":
			System.setProperty(Constants_Global.chromeKey,Constants_Global.chromePath);
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty(Constants_Global.firefoxKey,Constants_Global.firefoxPath);
			driver = new FirefoxDriver();
			break;
		case "ie":
			System.setProperty(Constants_Global.ieKey,Constants_Global.iePath);
			driver = new InternetExplorerDriver();
			break;
		default:
			break;
		}
		driver.manage().window().maximize();
	}
}
