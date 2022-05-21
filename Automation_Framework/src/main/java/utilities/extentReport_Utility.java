package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class extentReport_Utility {

    private static ExtentReports extent;
   public static ExtentTest logger;


    public static void blankFile_Creation(String classname)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss_SSS");
        Date now = new Date();
        String timeStamp = sdf.format(now);

        ExtentSparkReporter spark = new ExtentSparkReporter("./ExtentReports/"+classname+timeStamp+".html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
        spark.config().setDocumentTitle("Automation Report");
        spark.config().setReportName("Sample Report");


        logger=extent.createTest(classname);
        //System.setProperty("webdriver.chrome.driver", "/Users/rajisatish/IdeaProjects/Selenium_Basics/chromedriver");
        //driver = new ChromeDriver();
        //driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
    }


    public static void ReportGeneration(ITestResult result, WebDriver driver) throws IOException {
        if (result.getStatus() == ITestResult.SUCCESS) {
            logger.log(Status.PASS, MarkupHelper.createLabel(result.getMethod().getMethodName(), ExtentColor.GREEN));
        } else if (result.getStatus() == ITestResult.FAILURE) {
            logger.log(Status.FAIL, MarkupHelper.createLabel(result.getMethod().getMethodName(), ExtentColor.RED));
           // logger.log(Status.FAIL, MarkupHelper.createLabel(result.getMethod().getMethodName(), ExtentColor.RED));
            //logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshot_Utility.getscreenshot(driver)).build());
            logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot_Utility.getscreenshot(driver)).build());
        }

        extent.flush();
    }
}