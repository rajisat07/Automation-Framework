package baseClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import utilities.extentReport_Utility;
import utilities.utility_FetchProperty;

import java.io.IOException;

public class driverInstance {

    public WebDriver driver;
    @BeforeMethod
    public void initiateDriverInstance() throws IOException {
        String browsername =utility_FetchProperty.fetchProperty_Value("browser");

        switch(browsername)
        {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
                break;
            case "safari":
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
                break;


        }
        extentReport_Utility.blankFile_Creation(this.getClass().getSimpleName());
       // driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
       driver.get(utility_FetchProperty.fetchProperty_Value("url"));
       driver.manage().window().maximize();

    }
    @AfterMethod
    public void closeInstance(ITestResult result) throws IOException {
        extentReport_Utility.ReportGeneration(result, driver);
        driver.quit();
    }
}
